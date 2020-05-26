package com.feifei.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseLabel {

    private Long label_option_id;

    private String label_option_name;

    private String label_option_type;

    public Long getLabel_option_id() {
        return label_option_id;
    }

    public void setLabel_option_id(Long label_option_id) {
        this.label_option_id = label_option_id;
    }

    public String getLabel_option_name() {
        return label_option_name;
    }

    public void setLabel_option_name(String label_option_name) {
        this.label_option_name = label_option_name;
    }

    public String getLabel_option_type() {
        return label_option_type;
    }

    public void setLabel_option_type(String label_option_type) {
        this.label_option_type = label_option_type;
    }

}
