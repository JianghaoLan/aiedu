package org.cvlab.aiedu.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cvlab.aiedu.mapper.CourseImageMapper;
import org.cvlab.aiedu.domain.CourseImage;
import org.cvlab.aiedu.service.ICourseImageService;

/**
 * 课程课件图片Service业务层处理
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
@Service
public class CourseImageServiceImpl implements ICourseImageService 
{
    @Autowired
    private CourseImageMapper courseImageMapper;

    /**
     * 查询课程课件图片
     * 
     * @param imageId 课程课件图片主键
     * @return 课程课件图片
     */
    @Override
    public CourseImage selectCourseImageByImageId(Long imageId)
    {
        return courseImageMapper.selectCourseImageByImageId(imageId);
    }

    /**
     * 查询课程课件图片列表
     * 
     * @param courseImage 课程课件图片
     * @return 课程课件图片
     */
    @Override
    public List<CourseImage> selectCourseImageList(CourseImage courseImage)
    {
        return courseImageMapper.selectCourseImageList(courseImage);
    }

    /**
     * 新增课程课件图片
     * 
     * @param courseImage 课程课件图片
     * @return 结果
     */
    @Override
    public int insertCourseImage(CourseImage courseImage)
    {
        courseImage.setCreateTime(DateUtils.getNowDate());
        return courseImageMapper.insertCourseImage(courseImage);
    }

    /**
     * 修改课程课件图片
     * 
     * @param courseImage 课程课件图片
     * @return 结果
     */
    @Override
    public int updateCourseImage(CourseImage courseImage)
    {
        courseImage.setUpdateTime(DateUtils.getNowDate());
        return courseImageMapper.updateCourseImage(courseImage);
    }

    /**
     * 批量删除课程课件图片
     * 
     * @param imageIds 需要删除的课程课件图片主键
     * @return 结果
     */
    @Override
    public int deleteCourseImageByImageIds(Long[] imageIds)
    {
        return courseImageMapper.deleteCourseImageByImageIds(imageIds);
    }

    /**
     * 删除课程课件图片信息
     * 
     * @param imageId 课程课件图片主键
     * @return 结果
     */
    @Override
    public int deleteCourseImageByImageId(Long imageId)
    {
        return courseImageMapper.deleteCourseImageByImageId(imageId);
    }
}
