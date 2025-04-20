package SpringBoot.Spring_Mybatis_Homework.mapper;

import SpringBoot.Spring_Mybatis_Homework.DO.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public interface StudentCourseMapper {

    // 多对多关系：学生（students）与课程（courses）

    // 添加一条选课记录
    int insertStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId, Date enrollmentDate);
    // 删除一条选课记录
    int deleteStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId);
    // 查询一条选课记录
    StudentCourse selectStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId);
    // 修改一条选课记录
    int updateStudentCourseByStudentIdAndCourseId(Integer studentId, Integer courseId, Date enrollmentDate, Integer newCourseId);

}
