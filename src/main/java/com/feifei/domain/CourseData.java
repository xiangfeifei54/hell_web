package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseData {

    List<SpeCourse> speCourses;

    List<SysCoursePkg> sysCoursePkgs;

    Map<String, Subject> subjectMap;

    public List<SpeCourse> getSpeCourses() {
        return speCourses;
    }

    public void setSpeCourses(List<SpeCourse> speCourses) {
        this.speCourses = speCourses;
    }

    public List<SysCoursePkg> getSysCoursePkgs() {
        return sysCoursePkgs;
    }

    public void setSysCoursePkgs(List<SysCoursePkg> sysCoursePkgs) {
        this.sysCoursePkgs = sysCoursePkgs;
    }

    public Map<String, Subject> getSubjectMap() {
        return subjectMap;
    }

    public void setSubjectMap(Map<String, Subject> subjectMap) {
        this.subjectMap = subjectMap;
    }
}
