package org.cvlab.aiedu.service;

import java.util.List;
import org.cvlab.aiedu.domain.Teacher;

/**
 * 教师Service接口
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public interface ITeacherService 
{
    /**
     * 查询教师
     * 
     * @param teacherId 教师主键
     * @return 教师
     */
    public Teacher selectTeacherByTeacherId(Long teacherId);

    /**
     * 查询教师列表
     * 
     * @param teacher 教师
     * @return 教师集合
     */
    public List<Teacher> selectTeacherList(Teacher teacher);

    /**
     * 新增教师
     * 
     * @param teacher 教师
     * @return 结果
     */
    public int insertTeacher(Teacher teacher);

    /**
     * 修改教师
     * 
     * @param teacher 教师
     * @return 结果
     */
    public int updateTeacher(Teacher teacher);

    /**
     * 批量删除教师
     * 
     * @param teacherIds 需要删除的教师主键集合
     * @return 结果
     */
    public int deleteTeacherByTeacherIds(Long[] teacherIds);

    /**
     * 删除教师信息
     * 
     * @param teacherId 教师主键
     * @return 结果
     */
    public int deleteTeacherByTeacherId(Long teacherId);
}
