package org.cvlab.aiedu.service;

import java.util.List;
import org.cvlab.aiedu.domain.CourseImage;

/**
 * 课程课件图片Service接口
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public interface ICourseImageService 
{
    /**
     * 查询课程课件图片
     * 
     * @param imageId 课程课件图片主键
     * @return 课程课件图片
     */
    public CourseImage selectCourseImageByImageId(Long imageId);

    /**
     * 查询课程课件图片列表
     * 
     * @param courseImage 课程课件图片
     * @return 课程课件图片集合
     */
    public List<CourseImage> selectCourseImageList(CourseImage courseImage);

    /**
     * 新增课程课件图片
     * 
     * @param courseImage 课程课件图片
     * @return 结果
     */
    public int insertCourseImage(CourseImage courseImage);

    /**
     * 修改课程课件图片
     * 
     * @param courseImage 课程课件图片
     * @return 结果
     */
    public int updateCourseImage(CourseImage courseImage);

    /**
     * 批量删除课程课件图片
     * 
     * @param imageIds 需要删除的课程课件图片主键集合
     * @return 结果
     */
    public int deleteCourseImageByImageIds(Long[] imageIds);

    /**
     * 删除课程课件图片信息
     * 
     * @param imageId 课程课件图片主键
     * @return 结果
     */
    public int deleteCourseImageByImageId(Long imageId);
}
