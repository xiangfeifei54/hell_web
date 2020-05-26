package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeCourse {

    Long cid;

    String name;

    String pinyin;

    String cover_url;

    Long showid;

    Long payid;

    Long grade;

    String gradeName;

    Long subject;

    String subjectName;

    Byte status;

    Date recordtime;

    String cover_url_color;

    String time_plan;

    String hint_logo;

    String class_type;

    Long student_total;

    Long level;

    List<CourseLabel> course_labels;

    Boolean has_discount;

    Long pre_amount;

    Long af_amount;

    Date dis_bgtime;

    Date dis_edtime;

    Long sign_max;

    Long apply_num;

    Date sign_bgtime;

    Date first_sub_bgtime;

    Date first_sub_endtime;

    Date last_sub_bgtime;

    Date last_sub_endtime;

    Boolean applied;

    ClassInfo class_info;

    List<Teacher> te_list;

    Byte renew_type;

    String price;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public Long getShowid() {
        return showid;
    }

    public void setShowid(Long showid) {
        this.showid = showid;
    }

    public Long getPayid() {
        return payid;
    }

    public void setPayid(Long payid) {
        this.payid = payid;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getCover_url_color() {
        return cover_url_color;
    }

    public void setCover_url_color(String cover_url_color) {
        this.cover_url_color = cover_url_color;
    }

    public String getTime_plan() {
        return time_plan;
    }

    public void setTime_plan(String time_plan) {
        this.time_plan = time_plan;
    }

    public String getHint_logo() {
        return hint_logo;
    }

    public void setHint_logo(String hint_logo) {
        this.hint_logo = hint_logo;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    public Long getStudent_total() {
        return student_total;
    }

    public void setStudent_total(Long student_total) {
        this.student_total = student_total;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public List<CourseLabel> getCourse_labels() {
        return course_labels;
    }

    public void setCourse_labels(List<CourseLabel> course_labels) {
        this.course_labels = course_labels;
    }

    public Boolean getHas_discount() {
        return has_discount;
    }

    public void setHas_discount(Boolean has_discount) {
        this.has_discount = has_discount;
    }

    public Long getPre_amount() {
        return pre_amount;
    }

    public void setPre_amount(Long pre_amount) {
        this.pre_amount = pre_amount;
    }

    public Long getAf_amount() {
        return af_amount;
    }

    public void setAf_amount(Long af_amount) {
        this.af_amount = af_amount;
    }

    public Date getDis_bgtime() {
        return dis_bgtime;
    }

    public void setDis_bgtime(Date dis_bgtime) {
        this.dis_bgtime = dis_bgtime;
    }

    public Date getDis_edtime() {
        return dis_edtime;
    }

    public void setDis_edtime(Date dis_edtime) {
        this.dis_edtime = dis_edtime;
    }

    public Long getSign_max() {
        return sign_max;
    }

    public void setSign_max(Long sign_max) {
        this.sign_max = sign_max;
    }

    public Long getApply_num() {
        return apply_num;
    }

    public void setApply_num(Long apply_num) {
        this.apply_num = apply_num;
    }

    public Date getSign_bgtime() {
        return sign_bgtime;
    }

    public void setSign_bgtime(Date sign_bgtime) {
        this.sign_bgtime = sign_bgtime;
    }

    public Date getFirst_sub_bgtime() {
        return first_sub_bgtime;
    }

    public void setFirst_sub_bgtime(Date first_sub_bgtime) {
        this.first_sub_bgtime = first_sub_bgtime;
    }

    public Date getFirst_sub_endtime() {
        return first_sub_endtime;
    }

    public void setFirst_sub_endtime(Date first_sub_endtime) {
        this.first_sub_endtime = first_sub_endtime;
    }

    public Date getLast_sub_bgtime() {
        return last_sub_bgtime;
    }

    public void setLast_sub_bgtime(Date last_sub_bgtime) {
        this.last_sub_bgtime = last_sub_bgtime;
    }

    public Date getLast_sub_endtime() {
        return last_sub_endtime;
    }

    public void setLast_sub_endtime(Date last_sub_endtime) {
        this.last_sub_endtime = last_sub_endtime;
    }

    public Boolean getApplied() {
        return applied;
    }

    public void setApplied(Boolean applied) {
        this.applied = applied;
    }

    public ClassInfo getClass_info() {
        return class_info;
    }

    public void setClass_info(ClassInfo class_info) {
        this.class_info = class_info;
    }

    public List<Teacher> getTe_list() {
        return te_list;
    }

    public void setTe_list(List<Teacher> te_list) {
        this.te_list = te_list;
    }

    public Byte getRenew_type() {
        return renew_type;
    }

    public void setRenew_type(Byte renew_type) {
        this.renew_type = renew_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
