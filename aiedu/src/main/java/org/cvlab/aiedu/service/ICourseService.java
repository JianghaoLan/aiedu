package org.cvlab.aiedu.service;

import java.util.List;
import org.cvlab.aiedu.domain.Course;

/**
 * 课程Service接口
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public interface ICourseService 
{
    /**
     * 查询课程
     * 
     * @param courseId 课程主键
     * @return 课程
     */
    public Course selectCourseByCourseId(Long courseId);

    /**
     * 查询课程列表
     * 
     * @param course 课程
     * @return 课程集合
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 新增课程
     * 
     * @param course 课程
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 修改课程
     * 
     * @param course 课程
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 批量删除课程
     * 
     * @param courseIds 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteCourseByCourseIds(Long[] courseIds);

    /**
     * 删除课程信息
     * 
     * @param courseId 课程主键
     * @return 结果
     */
    public int deleteCourseByCourseId(Long courseId);
}
