package com.feifei.rest;

import com.feifei.util.CourseDataUtl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 历史缓存构造
     *
     * @return
     */
    @RequestMapping(value = "/history_create", method = RequestMethod.GET)
    @ResponseBody
    public String history() {
        CourseDataUtl.createOldCourseData();
        return "ok";
    }

}
