package com.crm.web.controller.crm;

import com.alibaba.fastjson.JSON;
import com.crm.common.annotation.Log;
import com.crm.common.config.Global;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.enums.BusinessType;
import com.crm.common.json.JSONObject;
import com.crm.crm.domain.CrmAppoint;
import com.crm.crm.domain.CrmCar;
import com.crm.crm.domain.CrmContacts;
import com.crm.crm.domain.CrmMessage;
import com.crm.crm.service.ICrmAppointService;
import com.crm.crm.service.ICrmCarService;
import com.crm.crm.service.ICrmContactsService;
import com.crm.crm.service.ICrmMessageService;
import com.crm.framework.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

/**
 *
 *
 * @author crm
 */
@Controller
public class CrmPersonalController extends BaseController
{
    private String prefix = "home/personal";
    private ShiroUtils shiroUtils;
    @Autowired
    private ICrmContactsService crmContactsService;
    @Autowired
    private ICrmMessageService crmMessageService;
    @Autowired
    private ICrmAppointService crmAppointService;
    @Autowired
    private ICrmCarService crmCarService;

    @GetMapping("/home/personal/person")
    public String personal(ModelMap mmap,HttpSession session)
    {
        System.out.println(shiroUtils.getIp());

        String username1=(String)session.getAttribute("username1");
        System.out.println(username1);
        if(username1==null||"".equals(username1)){
            return "redirect:/home";
        }
        mmap.put("CrmName", username1);
        System.out.println(username1);
        return prefix + "/person";
    }

    @GetMapping("/home/personal/person_body")
    public String personBody(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        int count = 0;
        if(username1==null||"".equals(username1)){
            return "redirect:/home";
        }
        mmap.put("crmct",crmContactsService.selectCrmByLoginName(username1));
        List<CrmMessage> list = crmMessageService.selectCrmMessageByLoginName(username1);
        for(CrmMessage list1 : list){
            if("N".equals(list1.getStatus()) || "".equals(list1.getStatus()) || list1.getStatus()==null)
                count++;
        }
        mmap.put("Unread", count);
        return prefix + "/person_body";
    }

    /**
     * 修改联系人
     */
    @GetMapping("home/crmuser/crmuser")
    public String edit(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        if(username1==null||"".equals(username1)){
            return "redirect:/home";
        }
//        mmap.put("CrmName", username1);
        CrmContacts crmContacts = crmContactsService.selectCrmByLoginName(username1);
        mmap.put("crmContacts", crmContacts);
        return "home/crmuser/crmuser";
    }

    /**
     * 修改保存联系人
     */
    @PostMapping("home/crmuser/crmuser")
    @ResponseBody
    public AjaxResult editSave(CrmContacts crmContacts)
    {
        return toAjax(crmContactsService.updateCrmContacts(crmContacts));
    }

    /**
     * 修改密码
     * @param mmap
     * @return
     */
    @GetMapping("home/crmuser/crmuserPwd")
    public String resetPwd(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        if(username1==null||"".equals(username1)){
            return "redirect:/home";
        }
        mmap.put("crmpwd", crmContactsService.selectCrmByLoginName(username1));
        return "home/crmuser/crmuserPwd";
    }

    @PostMapping("home/crmuser/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(CrmContacts crmContacts,String pwdc)
    {


        if(pwdc.equals(crmContacts.getPwd())){
            return toAjax(crmContactsService.updateCrmContacts(crmContacts));
        }
        return error();

    }

    /**
     * 我的预约
     * @param mmap
     * @param session
     * @return
     */
    @GetMapping("home/crmuser/crmappoint")
    public String appoint(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
//        String json = "";
        if(username1==null||"".equals(username1)){
            return "redirect:/home";
        }
        System.out.println(username1);
        List<CrmAppoint> list = crmAppointService.selectCrmAppointByLoginName(username1);

        int crmCount = list.size();
        mmap.put("crmCount",crmCount);
        mmap.put("crmAppoint",list);
        return "home/crmuser/crmappoint";
    }

    /**
     * 增加预约
     */
    @GetMapping("home/crmuser/crmappointadd")
    public String appointadd(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        if(username1==null||"".equals(username1)){
            return "500";
        }
        mmap.put("crmContacts", crmContactsService.selectCrmByLoginName(username1));

        List<CrmCar> cars = crmCarService.selectCrmCarAll();
        mmap.put("cars",cars);
        return "home/crmuser/crmappointadd";
    }
    @PostMapping("home/crmuser/crmappointadd")
    @ResponseBody
    public AjaxResult appointaddSave(CrmAppoint crmAppoint)
    {
        System.out.println(crmAppoint);
        if(crmAppoint.getName()==null||"".equals(crmAppoint.getName())){
            return error("请输入您的真实姓名");
        }else if (crmAppoint.getTime()==null||"".equals(crmAppoint.getTime())){
            return error("请输入预约时间");
        }else {
            return toAjax(crmAppointService.insertCrmAppoint(crmAppoint));
        }
    }
    @PostMapping( "home/crmuser/crmappointremove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmAppointService.deleteCrmAppointByIds(ids));
    }



    /**
     * 系统信息
     * @param mmap
     * @param session
     * @return
     */
    @GetMapping("home/crmuser/crmmsg")
    public String msg(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
//        String json = "";
        if(username1==null||"".equals(username1)){
            return "redirect:/home";
        }
        List<CrmMessage> list = crmMessageService.selectCrmMessageByLoginName(username1);
        int crmCount = list.size();
        mmap.put("crmCount",crmCount);
        mmap.put("crmMessage",list);
        return "home/crmuser/crmmsg";
    }

    /**
     * 详细系统信息
     */
    @GetMapping("home/crmuser/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmMessage crmMessage1 = new CrmMessage();
        crmMessage1.setId(id);
        crmMessage1.setStatus("Y");
        crmMessageService.updateCrmMessage(crmMessage1);
        CrmMessage crmMessage = crmMessageService.selectCrmMessageById(id);
        mmap.put("crmMessage", crmMessage);
        return "home/crmuser/crmmsgdetail";
    }


}
