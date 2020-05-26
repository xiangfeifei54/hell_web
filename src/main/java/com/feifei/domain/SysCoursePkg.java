package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SysCoursePkg {

    private String title;

    private Date course_bgtime;

    private Date course_endtime;

    private Long sold_count;

    private Date course_sign_endtime;

    private String course_min_price;

    private String course_max_price;

    private Long season;

    private String subject_package_id;

    private String cid_list;

    private String discount_price;

    Long grade;

    String gradeName;

    Long subject;

    String subjectName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCourse_bgtime() {
        return course_bgtime;
    }

    public void setCourse_bgtime(Date course_bgtime) {
        this.course_bgtime = course_bgtime;
    }

    public Date getCourse_endtime() {
        return course_endtime;
    }

    public void setCourse_endtime(Date course_endtime) {
        this.course_endtime = course_endtime;
    }

    public Long getSold_count() {
        return sold_count;
    }

    public void setSold_count(Long sold_count) {
        this.sold_count = sold_count;
    }

    public Date getCourse_sign_endtime() {
        return course_sign_endtime;
    }

    public void setCourse_sign_endtime(Date course_sign_endtime) {
        this.course_sign_endtime = course_sign_endtime;
    }

    public String getCourse_min_price() {
        return course_min_price;
    }

    public void setCourse_min_price(String course_min_price) {
        this.course_min_price = course_min_price;
    }

    public String getCourse_max_price() {
        return course_max_price;
    }

    public void setCourse_max_price(String course_max_price) {
        this.course_max_price = course_max_price;
    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }

    public String getSubject_package_id() {
        return subject_package_id;
    }

    public void setSubject_package_id(String subject_package_id) {
        this.subject_package_id = subject_package_id;
    }

    public String getCid_list() {
        return cid_list;
    }

    public void setCid_list(String cid_list) {
        this.cid_list = cid_list;
    }

    public String getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(String discount_price) {
        this.discount_price = discount_price;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
