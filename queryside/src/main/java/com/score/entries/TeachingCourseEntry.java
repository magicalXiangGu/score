package com.score.entries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachingCourse")
public class TeachingCourseEntry {

    @Id
    private String teachingCourseID;
    private String courseName;
    //课程类型：考试、考察
    private String courseType;
    //课程性质：必修、选修
    private String courseNature;

    public String getTeachingCourseID() {
        return teachingCourseID;
    }

    public void setTeachingCourseID(String teachingCourseID) {
        this.teachingCourseID = teachingCourseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseNature() {
        return courseNature;
    }

    public void setCourseNature(String courseNature) {
        this.courseNature = courseNature;
    }
}
