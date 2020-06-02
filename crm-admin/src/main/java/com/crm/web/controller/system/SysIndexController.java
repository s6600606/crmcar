package com.crm.web.controller.system;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.crm.common.json.JSONObject;
import com.crm.crm.domain.CrmAppoint;
import com.crm.crm.domain.CrmMsgFeedback;
import com.crm.crm.service.ICrmAppointService;
import com.crm.crm.service.ICrmMsgFeedbackService;
import com.crm.system.domain.SysMain;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.crm.common.config.Global;
import com.crm.common.core.controller.BaseController;
import com.crm.framework.util.ShiroUtils;
import com.crm.system.domain.SysMenu;
import com.crm.system.domain.SysUser;
import com.crm.system.service.ISysMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页 业务处理
 * 
 * @author crm
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ICrmMsgFeedbackService crmMsgFeedbackService;
    @Autowired
    private ICrmAppointService crmAppointService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);

        CrmAppoint crmAppoint = new CrmAppoint();
        crmAppoint.setStatus("N");
        CrmMsgFeedback crmMsgFeedback = new CrmMsgFeedback();
        crmMsgFeedback.setStatus("N");
        if(!crmAppointService.selectCrmAppointList(crmAppoint).isEmpty()){
            mmap.put("appoint", 1);
        }
        if(!crmMsgFeedbackService.selectCrmMsgFeedbackList(crmMsgFeedback).isEmpty()){
            mmap.put("msgback", 1);
        }
        return "index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap)
    {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
//        List<CrmAppoint> list = crmAppointService.selectCrmAppointList(new CrmAppoint());
//        mmap.put("appointlist", list);
        return "main";
    }
    @PostMapping("/system/main/post")
    @ResponseBody
    public JSONObject mainpost(SysMain sysMain)
    {
        CrmAppoint crmAppoint = new CrmAppoint();
        crmAppoint.setStatus("Y");
        for(Long aid:sysMain.getFinish()){
            crmAppoint.setId(aid);
            crmAppointService.updateCrmAppoint(crmAppoint);
        }

        crmAppoint.setStatus("N");
        for(Long aid:sysMain.getNoFinish()){
            crmAppoint.setId(aid);
            crmAppoint.setStatus("N");
            crmAppointService.updateCrmAppoint(crmAppoint);
        }
//        System.out.println(sysMain.getFinish());
//        System.out.println(sysMain.getNoFinish());
//        System.out.println(sysMain);

        JSONObject jsonObject = new JSONObject();

        CrmAppoint crmAppoint22 = new CrmAppoint();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zerotime = calendar.getTime();
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");

        crmAppoint22.setTime(zerotime);
        System.out.println(dFormat.format(zerotime));
        crmAppoint22.setStatus("Y");
        List<CrmAppoint> crmAppointListf = crmAppointService.selectCrmAppointList(crmAppoint22);
        jsonObject.put("finish",crmAppointListf);

        crmAppoint22.setStatus("N");
        List<CrmAppoint> crmAppointListnof = crmAppointService.selectCrmAppointList(crmAppoint22);
        jsonObject.put("noFinish",crmAppointListnof);

        return jsonObject;
    }
}
