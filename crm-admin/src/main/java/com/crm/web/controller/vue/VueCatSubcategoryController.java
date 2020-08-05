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
import com.crm.vue.domain.VueCatSubcategory;
import com.crm.vue.service.IVueCatSubcategoryService;

/**
 * 具体分类Controller
 * 
 * @author crm
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/vue/subcategory")
public class VueCatSubcategoryController extends BaseController
{
    private String prefix = "vue/subcategory";

    @Autowired
    private IVueCatSubcategoryService vueCatSubcategoryService;

    @RequiresPermissions("vue:subcategory:view")
    @GetMapping()
    public String subcategory()
    {
        return prefix + "/subcategory";
    }

    /**
     * 查询具体分类列表
     */
    @RequiresPermissions("vue:subcategory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueCatSubcategory vueCatSubcategory)
    {
        startPage();
        List<VueCatSubcategory> list = vueCatSubcategoryService.selectVueCatSubcategoryList(vueCatSubcategory);
        return getDataTable(list);
    }

    /**
     * 导出具体分类列表
     */
    @RequiresPermissions("vue:subcategory:export")
    @Log(title = "具体分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueCatSubcategory vueCatSubcategory)
    {
        List<VueCatSubcategory> list = vueCatSubcategoryService.selectVueCatSubcategoryList(vueCatSubcategory);
        ExcelUtil<VueCatSubcategory> util = new ExcelUtil<VueCatSubcategory>(VueCatSubcategory.class);
        return util.exportExcel(list, "subcategory");
    }

    /**
     * 新增具体分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存具体分类
     */
    @RequiresPermissions("vue:subcategory:add")
    @Log(title = "具体分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueCatSubcategory vueCatSubcategory)
    {
        return toAjax(vueCatSubcategoryService.insertVueCatSubcategory(vueCatSubcategory));
    }

    /**
     * 修改具体分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueCatSubcategory vueCatSubcategory = vueCatSubcategoryService.selectVueCatSubcategoryById(id);
        mmap.put("vueCatSubcategory", vueCatSubcategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存具体分类
     */
    @RequiresPermissions("vue:subcategory:edit")
    @Log(title = "具体分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueCatSubcategory vueCatSubcategory)
    {
        return toAjax(vueCatSubcategoryService.updateVueCatSubcategory(vueCatSubcategory));
    }

    /**
     * 删除具体分类
     */
    @RequiresPermissions("vue:subcategory:remove")
    @Log(title = "具体分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueCatSubcategoryService.deleteVueCatSubcategoryByIds(ids));
    }
}
