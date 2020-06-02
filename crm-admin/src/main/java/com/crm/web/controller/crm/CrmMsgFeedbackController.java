package com.crm.web.controller.crm;

import java.util.List;

import com.crm.crm.domain.CrmContacts;
import com.crm.crm.service.ICrmContactsService;
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
import com.crm.crm.domain.CrmMsgFeedback;
import com.crm.crm.service.ICrmMsgFeedbackService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 反馈建议Controller
 * 
 * @author crm
 * @date 2020-04-09
 */
@Controller
@RequestMapping("/crm/msgfeedback")
public class CrmMsgFeedbackController extends BaseController
{
    private String prefix = "crm/msgfeedback";

    @Autowired
    private ICrmMsgFeedbackService crmMsgFeedbackService;
    @Autowired
    private ICrmContactsService crmContactsService;
    @Autowired
    private ISysUserService SysUserService;

    @RequiresPermissions("crm:msgfeedback:view")
    @GetMapping()
    public String msgfeedback()
    {
        return prefix + "/msgfeedback";
    }

    /**
     * 查询反馈建议列表
     */
    @RequiresPermissions("crm:msgfeedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmMsgFeedback crmMsgFeedback)
    {
        startPage();
        List<CrmMsgFeedback> list = crmMsgFeedbackService.selectCrmMsgFeedbackList(crmMsgFeedback);
        return getDataTable(list);
    }

    /**
     * 导出反馈建议列表
     */
    @RequiresPermissions("crm:msgfeedback:export")
    @Log(title = "反馈建议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmMsgFeedback crmMsgFeedback)
    {
        List<CrmMsgFeedback> list = crmMsgFeedbackService.selectCrmMsgFeedbackList(crmMsgFeedback);
        ExcelUtil<CrmMsgFeedback> util = new ExcelUtil<CrmMsgFeedback>(CrmMsgFeedback.class);
        return util.exportExcel(list, "msgfeedback");
    }

    /**
     * 新增反馈建议
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("msgCt",crmContactsService.selectCrmContactsAll());
        mmap.put("msgAdm",SysUserService.selectUserAllAll());
        return prefix + "/add";
    }

    /**
     * 新增保存反馈建议
     */
    @RequiresPermissions("crm:msgfeedback:add")
    @Log(title = "反馈建议", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmMsgFeedback crmMsgFeedback)
    {
        return toAjax(crmMsgFeedbackService.insertCrmMsgFeedback(crmMsgFeedback));
    }

    /**
     * 修改反馈建议
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("msgCt", crmContactsService.selectCrmContactsAll());
        mmap.put("msgAdm", SysUserService.selectUserAllAll());

        CrmMsgFeedback crmMsgFeedback = crmMsgFeedbackService.selectCrmMsgFeedbackById(id);
        mmap.put("crmMsgFeedback", crmMsgFeedback);
        return prefix + "/edit";
    }

    /**
     * 修改保存反馈建议
     */
    @RequiresPermissions("crm:msgfeedback:edit")
    @Log(title = "反馈建议", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmMsgFeedback crmMsgFeedback)
    {
        return toAjax(crmMsgFeedbackService.updateCrmMsgFeedback(crmMsgFeedback));
    }

    /**
     * 详细反馈建议
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmMsgFeedback crmMsgFeedback1 = new CrmMsgFeedback();
        crmMsgFeedback1.setId(id);
        crmMsgFeedback1.setStatus("Y");
        crmMsgFeedbackService.updateCrmMsgFeedback(crmMsgFeedback1);
        mmap.put("msgCt",crmContactsService.selectCrmContactsAll());
        mmap.put("msgAdm",SysUserService.selectUserAllAll());
        CrmMsgFeedback crmMsgFeedback = crmMsgFeedbackService.selectCrmMsgFeedbackById(id);
        mmap.put("crmMsgFeedback", crmMsgFeedback);
        return prefix + "/detail";
    }

    @PostMapping("/alread")
    @ResponseBody
    public AjaxResult alread(CrmMsgFeedback crmMsgFeedback)
    {
        return toAjax(crmMsgFeedbackService.updateCrmMsgFeedback(crmMsgFeedback));
    }

    /**
     * 删除反馈建议
     */
    @RequiresPermissions("crm:msgfeedback:remove")
    @Log(title = "反馈建议", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmMsgFeedbackService.deleteCrmMsgFeedbackByIds(ids));
    }
}
