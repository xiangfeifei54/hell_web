package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseResponse {

    private String retcode;
    private Data result;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public Data getResult() {
        return result;
    }

    public void setResult(Data result) {
        this.result = result;
    }
}
