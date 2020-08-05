package com.crm.web.controller.vue;

import java.util.List;

import com.crm.common.annotation.Log;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.core.page.TableDataInfo;
import com.crm.common.enums.BusinessType;
import com.crm.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crm.vue.domain.VueCategory;
import com.crm.vue.service.IVueCategoryService;

/**
 * 分类Controller
 * 
 * @author crm
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/vue/category")
public class VueCategoryController extends BaseController
{
    private String prefix = "vue/category";

    @Autowired
    private IVueCategoryService vueCategoryService;

    @RequiresPermissions("vue:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询分类列表
     */
    @RequiresPermissions("vue:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueCategory vueCategory)
    {
        startPage();
        List<VueCategory> list = vueCategoryService.selectVueCategoryList(vueCategory);
        return getDataTable(list);
    }

    /**
     * 导出分类列表
     */
    @RequiresPermissions("vue:category:export")
    @Log(title = "分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueCategory vueCategory)
    {
        List<VueCategory> list = vueCategoryService.selectVueCategoryList(vueCategory);
        ExcelUtil<VueCategory> util = new ExcelUtil<VueCategory>(VueCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分类
     */
    @RequiresPermissions("vue:category:add")
    @Log(title = "分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueCategory vueCategory)
    {
        return toAjax(vueCategoryService.insertVueCategory(vueCategory));
    }

    /**
     * 修改分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueCategory vueCategory = vueCategoryService.selectVueCategoryById(id);
        mmap.put("vueCategory", vueCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存分类
     */
    @RequiresPermissions("vue:category:edit")
    @Log(title = "分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueCategory vueCategory)
    {
        return toAjax(vueCategoryService.updateVueCategory(vueCategory));
    }

    /**
     * 删除分类
     */
    @RequiresPermissions("vue:category:remove")
    @Log(title = "分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueCategoryService.deleteVueCategoryByIds(ids));
    }
}
