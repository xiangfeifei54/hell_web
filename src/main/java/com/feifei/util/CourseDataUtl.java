package com.feifei.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feifei.domain.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CourseDataUtl {

    public static final String index_url = "http://fudao.qq.com/";
    public static final String grade_prefix = "http://fudao.qq.com/grade/";
    public static final String subject_prefix = "http://fudao.qq.com/cgi-proxy/course/discover_subject?client=4&platform=3&version=30&showid=0&page=1&size=1000&grade=gradeId&subject=subjectId";
    public static final String course_detail_prefix = "http://fudao.qq.com/pc/course.html?course_id=";
    public static final Map<String, CourseData> courseHistory = new ConcurrentHashMap<>();
    public static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 当日key 用于数据缓存
     *
     * @return
     */
    public static String todayKey() {
        Date date = new Date();
        String key = new SimpleDateFormat("YYYY_MM_dd").format(date);
        return key;
    }

    /**
     * 历史统计构造
     */
    public static void createOldCourseData() {
        String k1 = "2020_05_21";
        String k2 = "2020_05_22";
        String k3 = "2020_05_23";
        String k4 = "2020_05_24";
        String k5 = "2020_05_25";

        CourseData data = todayCourseDataRefresh(true);
        courseHistory.put(k1, data);
        courseHistory.put(k2, data);
        courseHistory.put(k3, data);
        courseHistory.put(k4, data);
        courseHistory.put(k5, data);
    }


    /**
     * 历史课程获取
     *
     * @param historyKey
     * @return
     */
    public static CourseData discoveryHistoryCourseData(String historyKey) {
        CourseData courseData = courseHistory.get(historyKey);
        return courseData;
    }


    /**
     * 今日统计
     *
     * @param fresh 是否获取最新数据
     * @return
     */
    public static CourseData todayCourseDataRefresh(boolean fresh) {
        String todayKey = todayKey();
        CourseData courseData = courseHistory.get(todayKey);
        if (!fresh && courseData != null) {
            return courseData;
        }

        // grade and subject discovery
        Map<String, List<Subject>> gradeToSubject = new LinkedHashMap<>();
        Map<String, String> gradeIdToName = new HashMap<>();
        List<Grade> grades = discoveryGrades();
        for (Grade grade : grades) {
            String gradeId = grade.id;
            gradeIdToName.put(gradeId, grade.name);
            List<Subject> subjects = discoverySubject(gradeId);
            gradeToSubject.put(gradeId, subjects);
        }

        // course discovery
        Map<String, Subject> totalMap = new HashMap<>();
        List<SpeCourse> speCourses = new ArrayList<>();
        List<SysCoursePkg> sysCoursePkgs = new ArrayList<>();
        for (Map.Entry<String, List<Subject>> subjectsEntry : gradeToSubject.entrySet()) {
            String gradeId = subjectsEntry.getKey();
            String gradeName = gradeIdToName.get(gradeId);
            List<Subject> subjects = subjectsEntry.getValue();
            for (Subject subject : subjects) {
                String subjectId = subject.id;
                String subjectName = subject.name;
                CourseResponse response = discoveryCourse(gradeId, subjectId);
                if (response == null) {
                    continue;
                }
                Data data = response.getResult();

                // sysCoursePkg collect
                List<SysCoursePkg> sysCoursePkgList = data.getSys_course_pkg_list();
                if (sysCoursePkgList != null) {
                    for (SysCoursePkg sysCoursePkg : sysCoursePkgList) {
                        Subject subjectInstance = totalMap.get(subjectId);
                        if (subjectInstance == null) {
                            subjectInstance = subject;
                            totalMap.put(subjectId, subject);
                        }

                        subjectInstance.getSysCoursePkgs().add(sysCoursePkg);
                        subjectInstance.setCount(subjectInstance.getCount() + 1L);

                        sysCoursePkg.setGrade(Long.valueOf(gradeId));
                        sysCoursePkg.setGradeName(gradeName);
                        sysCoursePkg.setSubject(Long.valueOf(subjectId));
                        sysCoursePkg.setSubjectName(subjectName);
                        sysCoursePkgs.add(sysCoursePkg);
                    }

                }

                // speCourse collect
                SpeCourseListPage speCourseListPage = data.getSpe_course_list();
                if (speCourseListPage.getData() != null) {
                    for (SpeCourse course : speCourseListPage.getData()) {
                        Subject subjectInstance = totalMap.get(subjectId);
                        if (subjectInstance == null) {
                            subjectInstance = subject;
                            totalMap.put(subjectId, subject);
                        }
                        subjectInstance.getSpeCourses().add(course);
                        subjectInstance.setCount(subjectInstance.getCount() + 1L);
                        Long cid = course.getCid();
                        String price = discoveryCoursePrice(cid);
                        course.setPrice(price);
                        course.setSubjectName(subjectName);
                        course.setGradeName(gradeName);
                        speCourses.add(course);

                    }
                }

            }
        }

        // course data refresh
        courseData = new CourseData();
        courseData.setSpeCourses(speCourses);
        courseData.setSysCoursePkgs(sysCoursePkgs);
        courseData.setSubjectMap(totalMap);
        courseHistory.put(todayKey, courseData);

        return courseData;
    }

    /**
     * grade 获取
     *
     * @return
     */
    public static List<Grade> discoveryGrades() {
        List<Grade> grades = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect(index_url).get();
            Elements links = document.select("div.grade-area a");
            for (Element link : links) {
                String id = link.attr("href").substring(21).replaceAll("/", "");
                String name = link.getElementsByTag("span").text();
                grades.add(new Grade(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return grades;


    }

    /**
     * 科目获取
     *
     * @param gradeId
     * @return
     */
    public static List<Subject> discoverySubject(String gradeId) {
        System.out.println("discoverySubject start...");
        String url = grade_prefix + gradeId + "/";
        Document document = null;
        List<Subject> subjects = new ArrayList<>();
        try {
            document = Jsoup.connect(url).get();
            Elements links = document.select(".subject-list li a");
            if (links != null && links.size() > 0) {
                links.remove(0);
            }
            for (Element link : links) {
                String subjectId = link.attr("data-value");
                String subjectName = link.text();
                subjects.add(new Subject(subjectId, subjectName, 0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("discoverySubject start...");
        return subjects;
    }

    /**
     * 课程获取
     *
     * @param gradeId   年级id
     * @param subjectId 学科id
     * @return
     */
    public static CourseResponse discoveryCourse(String gradeId, String subjectId) {
        String url = subject_prefix.replaceAll("gradeId", gradeId).replaceAll("subjectId", subjectId);
        String content = null;
        CourseResponse response = null;
        try {
            content = get(url);
            if (content != null) {
                response = objectMapper.readValue(content, CourseResponse.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }

    /**
     * 获取课程价格
     *
     * @param courseId
     * @return
     */
    public static String discoveryCoursePrice(Long courseId) {
        String price = "";
        String url = course_detail_prefix + courseId;
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            if (document != null) {
                price = document.select("span.tt-price-integer").text();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return price.length() == 0 ? "0" : price;
    }


    /**
     * 用户请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("referer", "https://fudao.qq.com/");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        String res = null;
        try {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            // do something useful with the response body
            if (status == 200) {
                return entity != null ? EntityUtils.toString(entity) : null;
            }
            if (entity != null) {
                res = EntityUtils.toString(entity);
                // and ensure it is fully consumed
                EntityUtils.consume(entity);
            }
            return res;
        } finally {
            response.close();
        }

    }

    static class Grade {
        String id;
        String name;

        public Grade(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }


}