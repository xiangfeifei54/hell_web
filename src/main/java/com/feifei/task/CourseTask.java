package com.feifei.task;


import com.feifei.util.CourseDataUtl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CourseTask {

    @Scheduled(fixedRate = 1000 * 60 * 30)
    public void updateCourse() {
        System.out.println("CourseTask start...");
        CourseDataUtl.todayCourseDataRefresh(true);
        System.out.println("CourseTask end...");
    }

}
