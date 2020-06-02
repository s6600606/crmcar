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
import com.crm.crm.domain.CrmOrderStandard;
import com.crm.crm.service.ICrmOrderStandardService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 业绩目标Controller
 * 
 * @author crm
 * @date 2020-05-05
 */
@Controller
@RequestMapping("/crm/standard")
public class CrmOrderStandardController extends BaseController
{
    private String prefix = "crm/standard";

    @Autowired
    private ICrmOrderStandardService crmOrderStandardService;

    @RequiresPermissions("crm:standard:view")
    @GetMapping()
    public String standard()
    {
        return prefix + "/standard";
    }

    /**
     * 查询业绩目标列表
     */
    @RequiresPermissions("crm:standard:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmOrderStandard crmOrderStandard)
    {
        startPage();
        List<CrmOrderStandard> list = crmOrderStandardService.selectCrmOrderStandardList(crmOrderStandard);
        return getDataTable(list);
    }

    /**
     * 导出业绩目标列表
     */
    @RequiresPermissions("crm:standard:export")
    @Log(title = "业绩目标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmOrderStandard crmOrderStandard)
    {
        List<CrmOrderStandard> list = crmOrderStandardService.selectCrmOrderStandardList(crmOrderStandard);
        ExcelUtil<CrmOrderStandard> util = new ExcelUtil<CrmOrderStandard>(CrmOrderStandard.class);
        return util.exportExcel(list, "standard");
    }

    /**
     * 新增业绩目标
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业绩目标
     */
    @RequiresPermissions("crm:standard:add")
    @Log(title = "业绩目标", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmOrderStandard crmOrderStandard)
    {
        return toAjax(crmOrderStandardService.insertCrmOrderStandard(crmOrderStandard));
    }

    /**
     * 修改业绩目标
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmOrderStandard crmOrderStandard = crmOrderStandardService.selectCrmOrderStandardById(id);
        mmap.put("crmOrderStandard", crmOrderStandard);
        return prefix + "/edit";
    }

    /**
     * 修改保存业绩目标
     */
    @RequiresPermissions("crm:standard:edit")
    @Log(title = "业绩目标", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmOrderStandard crmOrderStandard)
    {
        return toAjax(crmOrderStandardService.updateCrmOrderStandard(crmOrderStandard));
    }

    /**
     * 删除业绩目标
     */
    @RequiresPermissions("crm:standard:remove")
    @Log(title = "业绩目标", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmOrderStandardService.deleteCrmOrderStandardByIds(ids));
    }
}
