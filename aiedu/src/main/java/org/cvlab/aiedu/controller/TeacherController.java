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
import org.cvlab.aiedu.domain.Teacher;
import org.cvlab.aiedu.service.ITeacherService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 教师Controller
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController
{
    @Autowired
    private ITeacherService teacherService;

    /**
     * 查询教师列表
     */
    @RequiresPermissions("aiedu:teacher:list")
    @GetMapping("/list")
    public TableDataInfo list(Teacher teacher)
    {
        startPage();
        List<Teacher> list = teacherService.selectTeacherList(teacher);
        return getDataTable(list);
    }

    /**
     * 导出教师列表
     */
    @RequiresPermissions("aiedu:teacher:export")
    @Log(title = "教师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Teacher teacher)
    {
        List<Teacher> list = teacherService.selectTeacherList(teacher);
        ExcelUtil<Teacher> util = new ExcelUtil<Teacher>(Teacher.class);
        util.exportExcel(response, list, "教师数据");
    }

    /**
     * 获取教师详细信息
     */
    @RequiresPermissions("aiedu:teacher:query")
    @GetMapping(value = "/{teacherId}")
    public AjaxResult getInfo(@PathVariable("teacherId") Long teacherId)
    {
        return success(teacherService.selectTeacherByTeacherId(teacherId));
    }

    /**
     * 新增教师
     */
    @RequiresPermissions("aiedu:teacher:add")
    @Log(title = "教师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Teacher teacher)
    {
        return toAjax(teacherService.insertTeacher(teacher));
    }

    /**
     * 修改教师
     */
    @RequiresPermissions("aiedu:teacher:edit")
    @Log(title = "教师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Teacher teacher)
    {
        return toAjax(teacherService.updateTeacher(teacher));
    }

    /**
     * 删除教师
     */
    @RequiresPermissions("aiedu:teacher:remove")
    @Log(title = "教师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teacherIds}")
    public AjaxResult remove(@PathVariable Long[] teacherIds)
    {
        return toAjax(teacherService.deleteTeacherByTeacherIds(teacherIds));
    }
}
