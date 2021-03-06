package com.score.handlers;

import com.score.domain.CourseStudent;
import com.score.entries.CourseStudentEntry;
import com.score.entries.CourseTeacherEntry;
import com.score.entries.TeachingClassEntry;
import com.score.entries.TeachingCourseEntry;
import com.score.events.TeachingClassCreatedEvent;
import com.score.repository.TeachingClassRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeachingClassEventHandler
{

    @Autowired
    private TeachingClassRepository teachingClassRepository;

    @EventHandler
    public void handler(TeachingClassCreatedEvent event){

        //初始化教学课程
        TeachingCourseEntry teachingCourseEntry = new TeachingCourseEntry(event.getTeachingCourse().getTeachingCourseID(),event.getTeachingCourse().getCourseName(),event.getTeachingCourse().getCourseType(),event.getTeachingCourse().getCourseNature());

        //初始化上课教员
        List<CourseTeacherEntry> courseTeacherEntries = null;
        event.getCourseTeachers().forEach(teacher->{
            CourseTeacherEntry courseTeacherEntry = new CourseTeacherEntry(teacher.getCourseTeacherID(),teacher.getCourseTeacherName(),teacher.getTeacherPosition().toString());
            courseTeacherEntries.add(courseTeacherEntry);
        });

        //初始化上课学员
        List<CourseStudentEntry> courseStudentEntries = null;
        event.getCourseStudents().forEach(student -> {
            CourseStudentEntry courseStudentEntry = new CourseStudentEntry(student.getCourseStudentID(),student.getStudentName());
            courseStudentEntries.add(courseStudentEntry);
        });

        TeachingClassEntry teachingClassEntry = new TeachingClassEntry(event.getTeachingClassID().getIdentifier(),event.getStudingInterval(),teachingCourseEntry,courseStudentEntries,courseTeacherEntries);

        teachingClassRepository.save(teachingClassEntry);
    }
}
