package SpringBoot.Spring_Mybatis_Homework.service.impl;

import SpringBoot.Spring_Mybatis_Homework.DO.StudentCourse;
import SpringBoot.Spring_Mybatis_Homework.mapper.StudentCourseMapper;
import SpringBoot.Spring_Mybatis_Homework.service.StudentCourseService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    StudentCourseMapper studentCourseMapper;

    public StudentCourseServiceImpl(StudentCourseMapper studentCourseMapper) {
        this.studentCourseMapper = studentCourseMapper;
    }

    @Override
    public int insertStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId, Date enrollmentDate) {
        return studentCourseMapper.insertStudentCourseByStudentIdAndCourseId(studentId, courseId, enrollmentDate);
    }

    @Override
    public int deleteStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        return studentCourseMapper.deleteStudentCourseByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public StudentCourse selectStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        return studentCourseMapper.selectStudentCourseByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public int updateStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId, Date enrollmentDate, Integer newCourseId) {
        return studentCourseMapper.updateStudentCourseByStudentIdAndCourseId(studentId, courseId, enrollmentDate, newCourseId);
    }
}
