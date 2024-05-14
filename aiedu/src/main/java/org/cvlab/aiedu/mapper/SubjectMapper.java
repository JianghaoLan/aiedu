package org.cvlab.aiedu.mapper;

import java.util.List;
import org.cvlab.aiedu.domain.Subject;

/**
 * 科目Mapper接口
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public interface SubjectMapper 
{
    /**
     * 查询科目
     * 
     * @param subjectId 科目主键
     * @return 科目
     */
    public Subject selectSubjectBySubjectId(Long subjectId);

    /**
     * 查询科目列表
     * 
     * @param subject 科目
     * @return 科目集合
     */
    public List<Subject> selectSubjectList(Subject subject);

    /**
     * 新增科目
     * 
     * @param subject 科目
     * @return 结果
     */
    public int insertSubject(Subject subject);

    /**
     * 修改科目
     * 
     * @param subject 科目
     * @return 结果
     */
    public int updateSubject(Subject subject);

    /**
     * 删除科目
     * 
     * @param subjectId 科目主键
     * @return 结果
     */
    public int deleteSubjectBySubjectId(Long subjectId);

    /**
     * 批量删除科目
     * 
     * @param subjectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubjectBySubjectIds(Long[] subjectIds);
}
