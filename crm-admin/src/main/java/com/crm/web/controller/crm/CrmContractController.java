package com.crm.web.controller.crm;

import java.util.List;

import com.crm.crm.service.ICrmCarService;
import com.crm.system.service.ISysUserService;
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
import com.crm.crm.domain.CrmContract;
import com.crm.crm.service.ICrmContractService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 合同Controller
 * 
 * @author crm
 * @date 2020-03-10
 */
@Controller
@RequestMapping("/crm/contract")
public class CrmContractController extends BaseController
{
    private String prefix = "crm/contract";

    @Autowired
    private ICrmContractService crmContractService;
    @Autowired
    private ICrmCarService crmCarService;
    @Autowired
    private ISysUserService SysUserService;

    @RequiresPermissions("crm:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }

    /**
     * 查询合同列表
     */
    @RequiresPermissions("crm:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmContract crmContract)
    {
        startPage();
        List<CrmContract> list = crmContractService.selectCrmContractList(crmContract);
        return getDataTable(list);
    }

    /**
     * 导出合同列表
     */
    @RequiresPermissions("crm:contract:export")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmContract crmContract)
    {
        List<CrmContract> list = crmContractService.selectCrmContractList(crmContract);
        ExcelUtil<CrmContract> util = new ExcelUtil<CrmContract>(CrmContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 新增合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("users",SysUserService.selectUserAllAll());
        mmap.put("sales",SysUserService.selectUserAll());
        mmap.put("crmCars",crmCarService.selectCrmCarAll());
        return prefix + "/add";
    }

    /**
     * 新增保存合同
     */
    @RequiresPermissions("crm:contract:add")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmContract crmContract)
    {
        return toAjax(crmContractService.insertCrmContract(crmContract));
    }

    /**
     * 修改合同
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmContract crmContract = crmContractService.selectCrmContractById(id);
        mmap.put("users",SysUserService.selectUserAllAll());
        mmap.put("sales",SysUserService.selectUserAll());
        mmap.put("crmCars",crmCarService.selectCrmCarAll());
        mmap.put("crmContract", crmContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同
     */
    @RequiresPermissions("crm:contract:edit")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmContract crmContract)
    {
        return toAjax(crmContractService.updateCrmContract(crmContract));
    }

    /**
     * 删除合同
     */
    @RequiresPermissions("crm:contract:remove")
    @Log(title = "合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmContractService.deleteCrmContractByIds(ids));
    }
}
