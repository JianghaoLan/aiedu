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
import org.cvlab.aiedu.domain.Subject;
import org.cvlab.aiedu.service.ISubjectService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 科目Controller
 * 
 * @author lanjianghao
 * @date 2024-05-11
 */
@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController
{
    @Autowired
    private ISubjectService subjectService;

    /**
     * 查询科目列表
     */
    @RequiresPermissions("aiedu:subject:list")
    @GetMapping("/list")
    public TableDataInfo list(Subject subject)
    {
        startPage();
        List<Subject> list = subjectService.selectSubjectList(subject);
        return getDataTable(list);
    }

    /**
     * 导出科目列表
     */
    @RequiresPermissions("aiedu:subject:export")
    @Log(title = "科目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Subject subject)
    {
        List<Subject> list = subjectService.selectSubjectList(subject);
        ExcelUtil<Subject> util = new ExcelUtil<Subject>(Subject.class);
        util.exportExcel(response, list, "科目数据");
    }

    /**
     * 获取科目详细信息
     */
    @RequiresPermissions("aiedu:subject:query")
    @GetMapping(value = "/{subjectId}")
    public AjaxResult getInfo(@PathVariable("subjectId") Long subjectId)
    {
        return success(subjectService.selectSubjectBySubjectId(subjectId));
    }

    /**
     * 新增科目
     */
    @RequiresPermissions("aiedu:subject:add")
    @Log(title = "科目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Subject subject)
    {
        return toAjax(subjectService.insertSubject(subject));
    }

    /**
     * 修改科目
     */
    @RequiresPermissions("aiedu:subject:edit")
    @Log(title = "科目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Subject subject)
    {
        return toAjax(subjectService.updateSubject(subject));
    }

    /**
     * 删除科目
     */
    @RequiresPermissions("aiedu:subject:remove")
    @Log(title = "科目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{subjectIds}")
    public AjaxResult remove(@PathVariable Long[] subjectIds)
    {
        return toAjax(subjectService.deleteSubjectBySubjectIds(subjectIds));
    }
}
