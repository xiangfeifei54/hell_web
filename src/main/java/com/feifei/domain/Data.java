package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private Long retcode;

    private Long grade;

    private SpeCourseListPage spe_course_list;

    private List<SysCoursePkg> sys_course_pkg_list;

    public Long getRetcode() {
        return retcode;
    }

    public void setRetcode(Long retcode) {
        this.retcode = retcode;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public SpeCourseListPage getSpe_course_list() {
        return spe_course_list;
    }

    public void setSpe_course_list(SpeCourseListPage spe_course_list) {
        this.spe_course_list = spe_course_list;
    }

    public List<SysCoursePkg> getSys_course_pkg_list() {
        return sys_course_pkg_list;
    }

    public void setSys_course_pkg_list(List<SysCoursePkg> sys_course_pkg_list) {
        this.sys_course_pkg_list = sys_course_pkg_list;
    }
}
