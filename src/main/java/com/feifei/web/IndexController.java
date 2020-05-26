package com.feifei.web;

import com.feifei.domain.CourseData;
import com.feifei.util.CourseDataUtl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    /**
     * 当日统计
     *
     * @param map
     * @return
     */
    @RequestMapping("/")
    public String index(ModelMap map) {
        CourseData courseData = CourseDataUtl.todayCourseDataRefresh(false);
        // 加入一个属性，用来在模板中读取
        map.addAttribute("courseData", courseData);
        map.addAttribute("history", CourseDataUtl.courseHistory);
        // return模板文件的名称，对应src/main/resources/templates/web.html
        return "statistics";
    }

    /**
     * 当日统计 获取最新数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/today")
    public String today(ModelMap map) {
        CourseData courseData = CourseDataUtl.todayCourseDataRefresh(true);
        // 加入一个属性，用来在模板中读取
        map.addAttribute("courseData", courseData);
        map.addAttribute("history", CourseDataUtl.courseHistory);
        // return模板文件的名称，对应src/main/resources/templates/web.html
        return "statistics";
    }

    /**
     * 历史统计
     *
     * @param map
     * @param day_key
     * @return
     */
    @RequestMapping(value = "/history")
    public String history(ModelMap map, @RequestParam("day_key") String day_key) {
        CourseData courseData = CourseDataUtl.discoveryHistoryCourseData(day_key);
        // 加入一个属性，用来在模板中读取
        map.addAttribute("courseData", courseData);
        map.addAttribute("day_key", day_key);
        // return模板文件的名称，对应src/main/resources/templates/web.html
        return "history";
    }

    /**
     * 学科详情
     *
     * @param map
     * @param subject_id
     * @param day_key
     * @return
     */
    @RequestMapping("/subject")
    public String index(ModelMap map, @RequestParam("subject_id") String subject_id, @RequestParam(value = "day_key"
            , required = false) String day_key) {
        if (day_key == null || day_key.length() == 0) {
            day_key = CourseDataUtl.todayKey();
        }
        CourseData courseData = CourseDataUtl.discoveryHistoryCourseData(day_key);
        // 加入一个属性，用来在模板中读取
        map.addAttribute("subject", courseData.getSubjectMap().get(subject_id));

        // return模板文件的名称，对应src/main/resources/templates/web.html
        return "subject";
    }

    /**
     * 学科历史
     *
     * @param map
     * @param subject_id
     * @param day_key
     * @return
     */
    @RequestMapping("/subject_history")
    public String subject_history(ModelMap map, @RequestParam("subject_id") String subject_id, @RequestParam("day_key") String day_key) {
        CourseData courseData = CourseDataUtl.discoveryHistoryCourseData(day_key);
        // 加入一个属性，用来在模板中读取
        map.addAttribute("subject", courseData.getSubjectMap().get(subject_id));
        map.addAttribute("day_key", day_key);

        // return模板文件的名称，对应src/main/resources/templates/web.html
        return "subject";
    }


}