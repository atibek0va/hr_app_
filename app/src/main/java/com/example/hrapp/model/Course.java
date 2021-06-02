package com.example.hrapp.model;

public class Course {

    int coursePhoto;
    String courseName;
    String courseUniver;

    public Course(){}

    public int getCoursePhoto() {
        return coursePhoto;
    }

    public void setCoursePhoto(int coursePhoto) {
        this.coursePhoto = coursePhoto;
    }

    public Course(int coursePhoto, String courseName, String courseUniver) {
        this.coursePhoto = coursePhoto;
        this.courseName = courseName;
        this.courseUniver = courseUniver;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseUniver() {
        return courseUniver;
    }

    public void setCourseUniver(String courseUniver) {
        this.courseUniver = courseUniver;
    }
}
