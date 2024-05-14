package org.cvlab.aiedu.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import org.cvlab.aiedu.domain.CourseImage;
import org.cvlab.aiedu.service.ICourseImageService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 课程课件图片Controller
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
@RestController
@RequestMapping("/courseImage")
public class CourseImageController extends BaseController
{
    @Autowired
    private ICourseImageService courseImageService;

    /**
     * 查询课程课件图片列表
     */
    @RequiresPermissions("aiedu:courseImage:list")
    @GetMapping("/list")
    public TableDataInfo list(CourseImage courseImage)
    {
        startPage();
        List<CourseImage> list = courseImageService.selectCourseImageList(courseImage);
        return getDataTable(list);
    }

    /**
     * 导出课程课件图片列表
     */
    @RequiresPermissions("aiedu:courseImage:export")
    @Log(title = "课程课件图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseImage courseImage)
    {
        List<CourseImage> list = courseImageService.selectCourseImageList(courseImage);
        ExcelUtil<CourseImage> util = new ExcelUtil<CourseImage>(CourseImage.class);
        util.exportExcel(response, list, "课程课件图片数据");
    }

    /**
     * 获取课程课件图片详细信息
     */
    @RequiresPermissions("aiedu:courseImage:query")
    @GetMapping(value = "/{imageId}")
    public AjaxResult getInfo(@PathVariable("imageId") Long imageId)
    {
        return success(courseImageService.selectCourseImageByImageId(imageId));
    }

    /**
     * 新增课程课件图片
     */
    @RequiresPermissions("aiedu:courseImage:add")
    @Log(title = "课程课件图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseImage courseImage)
    {
        return toAjax(courseImageService.insertCourseImage(courseImage));
    }

    /**
     * 修改课程课件图片
     */
    @RequiresPermissions("aiedu:courseImage:edit")
    @Log(title = "课程课件图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseImage courseImage)
    {
        return toAjax(courseImageService.updateCourseImage(courseImage));
    }

    /**
     * 删除课程课件图片
     */
    @RequiresPermissions("aiedu:courseImage:remove")
    @Log(title = "课程课件图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{imageIds}")
    public AjaxResult remove(@PathVariable Long[] imageIds)
    {
        return toAjax(courseImageService.deleteCourseImageByImageIds(imageIds));
    }
}
