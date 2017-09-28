package com.score.aggregates;

import com.score.commands.CreateTeachingClassCommand;
import com.score.domain.CourseStudent;
import com.score.domain.CourseTeacher;
import com.score.domain.TeachingClassID;
import com.score.domain.TeachingCourse;
import com.score.events.TeachingClassCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class TeachingClass {

    @AggregateIdentifier
    private TeachingClassID teachingClassID;

    @AggregateMember
    private TeachingCourse teachingCourse;

    //学时时间段（学期）
    private String studingInterval;
    @AggregateMember
    private ArrayList<CourseTeacher> courseTeachers;
    @AggregateMember
    private ArrayList<CourseStudent> courseStudents;

    public TeachingClass() {
    }

    public TeachingClass(TeachingClassID teachingClassID, TeachingCourse teachingCourse, String studingInterval, ArrayList<CourseTeacher> courseTeachers, ArrayList<CourseStudent> courseStudents) {
        this.teachingClassID = teachingClassID;
        this.teachingCourse = teachingCourse;
        this.studingInterval = studingInterval;
        this.courseTeachers = courseTeachers;
        this.courseStudents = courseStudents;
    }

    public TeachingClassID getTeachingClassID() {
        return teachingClassID;
    }

    public TeachingCourse getTeachingCourse() {
        return teachingCourse;
    }

    public String getStudingInterval() {
        return studingInterval;
    }

    public ArrayList<CourseTeacher> getCourseTeachers() {
        return courseTeachers;
    }

    public ArrayList<CourseStudent> getCourseStudents() {
        return courseStudents;
    }
}
