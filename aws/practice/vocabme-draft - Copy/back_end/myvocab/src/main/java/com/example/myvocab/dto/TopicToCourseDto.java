package com.example.myvocab.dto;

import com.example.myvocab.model.CourseCategory;

public interface TopicToCourseDto {
    Long getId();

    String getTitle();

    CourseInfo getCourse();

    interface CourseInfo {
        Long getId();
        CourseCategory getCategory();
    }
}
