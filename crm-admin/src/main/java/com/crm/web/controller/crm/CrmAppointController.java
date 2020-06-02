package com.crm.web.controller.crm;

import java.util.List;

import com.crm.crm.domain.CrmAppoint;
import com.crm.crm.domain.CrmCar;
import com.crm.crm.domain.CrmMsgFeedback;
import com.crm.crm.service.ICrmAppointService;
import com.crm.crm.service.ICrmCarService;
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
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

import javax.servlet.http.HttpSession;

/**
 * 预约信息Controller
 * 
 * @author crm
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/crm/appoint")
public class CrmAppointController extends BaseController
{
    private String prefix = "crm/appoint";


    @Autowired
    private ICrmAppointService crmAppointService;
    @Autowired
    private ICrmCarService crmCarService;
    @Autowired
    private ICrmContactsService crmContactsService;

    @RequiresPermissions("crm:appoint:view")
    @GetMapping()
    public String appoint()
    {
        return prefix + "/appoint";
    }

    /**
     * 查询预约信息列表
     */
    @RequiresPermissions("crm:appoint:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmAppoint crmAppoint)
    {
        startPage();
        List<CrmAppoint> list = crmAppointService.selectCrmAppointList(crmAppoint);
//        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 导出预约信息列表
     */
    @RequiresPermissions("crm:appoint:export")
    @Log(title = "预约信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmAppoint crmAppoint)
    {
        List<CrmAppoint> list = crmAppointService.selectCrmAppointList(crmAppoint);
        ExcelUtil<CrmAppoint> util = new ExcelUtil<CrmAppoint>(CrmAppoint.class);
        return util.exportExcel(list, "appoint");
    }

    /**
     * 新增预约信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("buyPeople",crmContactsService.selectCrmContactsAll());
        mmap.put("crmCars",crmCarService.selectCrmCarAll());
        return prefix + "/add";
    }

    /**
     * 新增保存预约信息
     */
    @RequiresPermissions("crm:appoint:add")
    @Log(title = "预约信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmAppoint crmAppoint)
    {
        System.out.println(crmAppoint);
        return toAjax(crmAppointService.insertCrmAppoint(crmAppoint));
    }

    /**
     * 修改预约信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("buyPeople",crmContactsService.selectCrmContactsAll());
        mmap.put("crmCars",crmCarService.selectCrmCarAll());
        CrmAppoint crmAppoint = crmAppointService.selectCrmAppointById(id);
        mmap.put("crmAppoint", crmAppoint);

        return prefix + "/edit";
    }

    /**
     * 修改保存预约信息
     */
    @RequiresPermissions("crm:appoint:edit")
    @Log(title = "预约信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmAppoint crmAppoint)
    {
        return toAjax(crmAppointService.updateCrmAppoint(crmAppoint));
    }


    @PostMapping("/alread")
    @ResponseBody
    public AjaxResult alread(CrmAppoint crmAppoint)
    {
        return toAjax(crmAppointService.updateCrmAppoint(crmAppoint));
    }



    /**
     * 删除预约信息
     */
    @RequiresPermissions("crm:appoint:remove")
    @Log(title = "预约信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmAppointService.deleteCrmAppointByIds(ids));
    }

}
