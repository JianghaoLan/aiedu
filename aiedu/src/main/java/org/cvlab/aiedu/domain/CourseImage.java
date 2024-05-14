package org.cvlab.aiedu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 课程课件图片对象 aiedu_course_image
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public class CourseImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片ID */
    private Long imageId;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 图片URL */
    private String imageUrl;

    /** 图片页码，从1开始 */
    @Excel(name = "图片页码，从1开始")
    private Long pageNum;

    /** 课程介绍 */
    @Excel(name = "课程介绍")
    private String intro;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setImageId(Long imageId) 
    {
        this.imageId = imageId;
    }

    public Long getImageId() 
    {
        return imageId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setPageNum(Long pageNum) 
    {
        this.pageNum = pageNum;
    }

    public Long getPageNum() 
    {
        return pageNum;
    }
    public void setIntro(String intro) 
    {
        this.intro = intro;
    }

    public String getIntro() 
    {
        return intro;
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
            .append("imageId", getImageId())
            .append("courseId", getCourseId())
            .append("imageUrl", getImageUrl())
            .append("pageNum", getPageNum())
            .append("intro", getIntro())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
