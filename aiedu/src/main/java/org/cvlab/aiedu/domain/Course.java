package org.cvlab.aiedu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 课程对象 aiedu_course
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long courseId;

    /** 科目ID */
    @Excel(name = "科目ID")
    private Long subjectId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 封面URL */
    @Excel(name = "封面URL")
    private String coverUrl;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setSubjectId(Long subjectId) 
    {
        this.subjectId = subjectId;
    }

    public Long getSubjectId() 
    {
        return subjectId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCoverUrl(String coverUrl) 
    {
        this.coverUrl = coverUrl;
    }

    public String getCoverUrl() 
    {
        return coverUrl;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("subjectId", getSubjectId())
            .append("courseName", getCourseName())
            .append("coverUrl", getCoverUrl())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
