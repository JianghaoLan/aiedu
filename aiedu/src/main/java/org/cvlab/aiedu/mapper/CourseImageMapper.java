package org.cvlab.aiedu.mapper;

import java.util.List;
import org.cvlab.aiedu.domain.CourseImage;

/**
 * 课程课件图片Mapper接口
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
public interface CourseImageMapper 
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
     * 删除课程课件图片
     * 
     * @param imageId 课程课件图片主键
     * @return 结果
     */
    public int deleteCourseImageByImageId(Long imageId);

    /**
     * 批量删除课程课件图片
     * 
     * @param imageIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseImageByImageIds(Long[] imageIds);
}
