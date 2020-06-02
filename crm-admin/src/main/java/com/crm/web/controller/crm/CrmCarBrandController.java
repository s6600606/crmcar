package com.crm.web.controller.crm;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crm.common.annotation.Log;
import com.crm.common.enums.BusinessType;
import com.crm.crm.domain.CrmCarBrand;
import com.crm.crm.service.ICrmCarBrandService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 汽车名Controller
 * 
 * @author crm
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/crm/brand")
public class CrmCarBrandController extends BaseController
{
    private String prefix = "crm/brand";

    @Autowired
    private ICrmCarBrandService crmCarBrandService;

    @RequiresPermissions("crm:brand:view")
    @GetMapping()
    public String brand()
    {
        return prefix + "/brand";
    }

    /**
     * 查询汽车名列表
     */
    @RequiresPermissions("crm:brand:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmCarBrand crmCarBrand)
    {
        startPage();
        List<CrmCarBrand> list = crmCarBrandService.selectCrmCarBrandList(crmCarBrand);
        return getDataTable(list);
    }

    /**
     * 导出汽车名列表
     */
    @RequiresPermissions("crm:brand:export")
    @Log(title = "汽车名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmCarBrand crmCarBrand)
    {
        List<CrmCarBrand> list = crmCarBrandService.selectCrmCarBrandList(crmCarBrand);
        ExcelUtil<CrmCarBrand> util = new ExcelUtil<CrmCarBrand>(CrmCarBrand.class);
        return util.exportExcel(list, "brand");
    }

    /**
     * 新增汽车名
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存汽车名
     */
    @RequiresPermissions("crm:brand:add")
    @Log(title = "汽车名", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmCarBrand crmCarBrand)
    {
        return toAjax(crmCarBrandService.insertCrmCarBrand(crmCarBrand));
    }

    /**
     * 修改汽车名
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmCarBrand crmCarBrand = crmCarBrandService.selectCrmCarBrandById(id);
        mmap.put("crmCarBrand", crmCarBrand);
        return prefix + "/edit";
    }

    /**
     * 修改保存汽车名
     */
    @RequiresPermissions("crm:brand:edit")
    @Log(title = "汽车名", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmCarBrand crmCarBrand)
    {
        return toAjax(crmCarBrandService.updateCrmCarBrand(crmCarBrand));
    }

    /**
     * 删除汽车名
     */
    @RequiresPermissions("crm:brand:remove")
    @Log(title = "汽车名", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmCarBrandService.deleteCrmCarBrandByIds(ids));
    }
}
