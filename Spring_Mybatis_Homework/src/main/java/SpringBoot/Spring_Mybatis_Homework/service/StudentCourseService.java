package SpringBoot.Spring_Mybatis_Homework.service;

import SpringBoot.Spring_Mybatis_Homework.DO.StudentCourse;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */
public interface StudentCourseService {
    int insertStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId, Date enrollmentDate);
    int deleteStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId);
    StudentCourse selectStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId);
    int updateStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId, Date enrollmentDate,Integer newCourseId);

}
