package com.feifei.domain;

public class Teacher {

    private String name;

    private  String cover_url;

    private  String introduce;

    private String platfrom_role;

    private String cover_small_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPlatfrom_role() {
        return platfrom_role;
    }

    public void setPlatfrom_role(String platfrom_role) {
        this.platfrom_role = platfrom_role;
    }

    public String getCover_small_url() {
        return cover_small_url;
    }

    public void setCover_small_url(String cover_small_url) {
        this.cover_small_url = cover_small_url;
    }
}
