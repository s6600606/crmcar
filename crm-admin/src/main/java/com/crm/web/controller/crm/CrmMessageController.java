package com.crm.web.controller.crm;

import java.util.List;

import com.crm.crm.domain.CrmContacts;
import com.crm.crm.domain.CrmMessage;
import com.crm.crm.service.ICrmContactsService;
import com.crm.crm.service.ICrmMessageService;
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
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 系统消息Controller
 * 
 * @author crm
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/crm/message")
public class CrmMessageController extends BaseController
{
    private String prefix = "crm/message";

    @Autowired
    private ICrmMessageService crmMessageService;
    @Autowired
    private ICrmContactsService crmContactsService;
    @Autowired
    private ISysUserService SysUserService;

    @RequiresPermissions("crm:message:view")
    @GetMapping()
    public String message()
    {
        return prefix + "/message";
    }

    /**
     * 查询系统消息列表
     */
    @RequiresPermissions("crm:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmMessage crmMessage)
    {
        startPage();
        List<CrmMessage> list = crmMessageService.selectCrmMessageList(crmMessage);
        return getDataTable(list);
    }

    /**
     * 导出系统消息列表
     */
    @RequiresPermissions("crm:message:export")
    @Log(title = "系统消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmMessage crmMessage)
    {
        List<CrmMessage> list = crmMessageService.selectCrmMessageList(crmMessage);
        ExcelUtil<CrmMessage> util = new ExcelUtil<CrmMessage>(CrmMessage.class);
        return util.exportExcel(list, "message");
    }

    /**
     * 新增系统消息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("msgCt",crmContactsService.selectCrmContactsAll());
        mmap.put("msgAdm",SysUserService.selectUserAllAll());
        return prefix + "/add";
    }

    /**
     * 新增保存系统消息
     */
    @RequiresPermissions("crm:message:add")
    @Log(title = "系统消息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmMessage crmMessage)
    {
        return toAjax(crmMessageService.insertCrmMessage(crmMessage));
    }

    @GetMapping("/addAll")
    public String addAll(ModelMap mmap)
    {
        return prefix + "/addAll";
    }
    @RequiresPermissions("crm:message:add")
    @Log(title = "系统消息", businessType = BusinessType.INSERT)
    @PostMapping("/addAll")
    @ResponseBody
    public AjaxResult addAllSave(CrmMessage crmMessage)
    {
        try {
            List<CrmContacts> crmContactsList = crmContactsService.selectCrmContactsAll();
            for (CrmContacts crmContacts : crmContactsList) {
                crmMessage.setAddresseeId(crmContacts.getId());
                crmMessageService.insertCrmMessageAll(crmMessage);
            }
        }catch (Exception e){
            return error();
        }
        return success();
    }



    /**
     * 修改系统消息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("msgCt",crmContactsService.selectCrmContactsAll());
        mmap.put("msgAdm",SysUserService.selectUserAllAll());
        CrmMessage crmMessage = crmMessageService.selectCrmMessageById(id);
        mmap.put("crmMessage", crmMessage);
        return prefix + "/edit";
    }

    /**
     * 修改保存系统消息
     */
    @RequiresPermissions("crm:message:edit")
    @Log(title = "系统消息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmMessage crmMessage)
    {
        return toAjax(crmMessageService.updateCrmMessage(crmMessage));
    }

    /**
     * 详细反馈建议
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmMessage crmMessage1 = new CrmMessage();
        crmMessage1.setId(id);
        crmMessage1.setStatus("Y");
        crmMessageService.updateCrmMessage(crmMessage1);
        mmap.put("msgCt",crmContactsService.selectCrmContactsAll());
        mmap.put("msgAdm",SysUserService.selectUserAllAll());
        CrmMessage crmMessage = crmMessageService.selectCrmMessageById(id);
        mmap.put("crmMessage", crmMessage);
        return prefix + "/detail";
    }

    @PostMapping("/alread")
    @ResponseBody
    public AjaxResult alread(CrmMessage crmMessage)
    {
        return toAjax(crmMessageService.updateCrmMessage(crmMessage));
    }

    /**
     * 删除系统消息
     */
    @RequiresPermissions("crm:message:remove")
    @Log(title = "系统消息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmMessageService.deleteCrmMessageByIds(ids));
    }
}
