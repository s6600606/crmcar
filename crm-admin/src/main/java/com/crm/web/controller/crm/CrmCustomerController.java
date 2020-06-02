package com.crm.web.controller.crm;

import com.crm.common.annotation.Log;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.core.page.TableDataInfo;
import com.crm.common.enums.BusinessType;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.crm.domain.CrmCustomer;
import com.crm.crm.service.ICrmCustomerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 联系人Controller
 * 
 * @author crm
 * @date 2020-03-02
 */
@Controller
@RequestMapping("/crm/customer")
public class CrmCustomerController extends BaseController
{
    private String prefix = "crm/customer";

    @Autowired
    private ICrmCustomerService crmCustomerService;

    @RequiresPermissions("crm:customer:view")
    @GetMapping()
    public String customer()
    {
        return prefix + "/customer";
    }

    /**
     * 查询联系人列表
     */
    @RequiresPermissions("crm:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmCustomer crmCustomer)
    {
        startPage();
        List<CrmCustomer> list = crmCustomerService.selectCrmCustomerList(crmCustomer);
        return getDataTable(list);
    }

    /**
     * 导出联系人列表
     */
    @RequiresPermissions("crm:customer:export")
    @Log(title = "联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmCustomer crmCustomer)
    {
        List<CrmCustomer> list = crmCustomerService.selectCrmCustomerList(crmCustomer);
        ExcelUtil<CrmCustomer> util = new ExcelUtil<CrmCustomer>(CrmCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 新增联系人
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存联系人
     */
    @RequiresPermissions("crm:customer:add")
    @Log(title = "联系人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmCustomer crmCustomer)
    {
        return toAjax(crmCustomerService.insertCrmCustomer(crmCustomer));
    }

    @GetMapping("/car_web/")
    public String home()
    {
        return prefix + "/car_web/index";
    }

    /**
     * 修改联系人
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmCustomer crmCustomer = crmCustomerService.selectCrmCustomerById(id);
        mmap.put("crmCustomer", crmCustomer);
        return prefix + "/edit";
    }

    /**
     * 修改保存联系人
     */
    @RequiresPermissions("crm:customer:edit")
    @Log(title = "联系人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmCustomer crmCustomer)
    {
        return toAjax(crmCustomerService.updateCrmCustomer(crmCustomer));
    }

    /**
     * 删除联系人
     */
    @RequiresPermissions("crm:customer:remove")
    @Log(title = "联系人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmCustomerService.deleteCrmCustomerByIds(ids));
    }
}
