package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subject {

    public String id;
    public String name;
    public long count;
    List<SpeCourse> speCourses = new ArrayList<>();
    List<SysCoursePkg> sysCoursePkgs = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

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

    public Subject(String id, String name, long count, List<SpeCourse> speCourses, List<SysCoursePkg> sysCoursePkgs) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.speCourses = speCourses;
        this.sysCoursePkgs = sysCoursePkgs;
    }

    public Subject(String id, String name, long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }


}
