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
import com.crm.crm.domain.CrmContacts;
import com.crm.crm.service.ICrmContactsService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 联系人Controller
 * 
 * @author crm
 * @date 2020-03-02
 */
@Controller
@RequestMapping("/crm/contacts")
public class CrmContactsController extends BaseController
{
    private String prefix = "crm/contacts";

    @Autowired
    private ICrmContactsService crmContactsService;

    @RequiresPermissions("crm:contacts:view")
    @GetMapping()
    public String contacts()
    {
        return prefix + "/contacts";
    }

    /**
     * 查询联系人列表
     */
    @RequiresPermissions("crm:contacts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmContacts crmContacts)
    {
        startPage();
        List<CrmContacts> list = crmContactsService.selectCrmContactsList(crmContacts);
        return getDataTable(list);
    }

    /**
     * 导出联系人列表
     */
    @RequiresPermissions("crm:contacts:export")
    @Log(title = "联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmContacts crmContacts)
    {
        List<CrmContacts> list = crmContactsService.selectCrmContactsList(crmContacts);
        ExcelUtil<CrmContacts> util = new ExcelUtil<CrmContacts>(CrmContacts.class);
        return util.exportExcel(list, "contacts");
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
    @RequiresPermissions("crm:contacts:add")
    @Log(title = "联系人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmContacts crmContacts)
    {
        System.out.println(crmContacts);
        return toAjax(crmContactsService.insertCrmContacts(crmContacts));
    }

    /**
     * 修改联系人
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmContacts crmContacts = crmContactsService.selectCrmContactsById(id);
        mmap.put("crmContacts", crmContacts);
        return prefix + "/edit";
    }

    /**
     * 修改保存联系人
     */
    @RequiresPermissions("crm:contacts:edit")
    @Log(title = "联系人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmContacts crmContacts)
    {
        return toAjax(crmContactsService.updateCrmContacts(crmContacts));
    }

    /**
     * 删除联系人
     */
    @RequiresPermissions("crm:contacts:remove")
    @Log(title = "联系人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmContactsService.deleteCrmContactsByIds(ids));
    }
}
