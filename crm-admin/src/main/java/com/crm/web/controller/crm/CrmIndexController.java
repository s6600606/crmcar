package com.crm.web.controller.crm;

import com.google.common.collect.Lists;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.ServletUtils;
import com.crm.crm.domain.*;
import com.crm.crm.service.*;
import com.crm.framework.util.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 登录验证
 *
 * @author crm
 */
@Controller
public class CrmIndexController extends BaseController
{
    @Autowired
    private ICrmContactsService crmContactsService;
    @Autowired
    private ICrmCarService crmCarService;
    @Autowired
    private ICrmAppointService crmAppointService;
    @Autowired
    private ICrmCarBrandService crmCarBrandService;
    @Autowired
    private ICrmMsgFeedbackService crmMsgFeedbackService;
    @Autowired
    private ICrmMessageService crmMessageService;

    private ShiroUtils shiroUtils;

    private String prefix = "home";

    @GetMapping("/home")
    public String home(ModelMap mmap,HttpSession session)
    {
        System.out.println(shiroUtils.getIp());
        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        List<CrmCar> carlist = crmCarService.selectCrmCarhomeLimit();
        mmap.put("CrmCarLimit", carlist);
        return prefix + "/index";

    }

    @GetMapping("/home/register")
    public String register(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return prefix + "/register";
    }
    @PostMapping("/home/register")
    @ResponseBody
    public AjaxResult ajaxRegister(String tel, String email, String pwd, String pwdc, HttpSession session)
    {
        System.out.println(tel+"--"+email+"--"+pwd+"--"+pwdc);
        String msg1 = "该手机号码已被注册";
        String msg2 = "该邮箱已被注册";
        String msg3 = "两次密码不统一";
        String msg4 = "请输入电话号码和邮箱";
        String msg6 = "请输入密码";
        try
        {
            CrmContacts crmContacts1 = crmContactsService.selectCrmByTel(tel);
            CrmContacts crmContacts2 = crmContactsService.selectCrmByEmail(email);
            if(!pwd.equals(pwdc)){
                return error(msg3);
            }else if(crmContacts1!=null){
                return error(msg1);
            }else if(crmContacts2!=null){
                return error(msg2);
            }else if("".equals(tel)&& "".equals(email)){
                return error(msg4);
            }else if("".equals(pwd)||"".equals(pwdc)){
                return error(msg6);
            }
            CrmContacts crmContacts5 = new CrmContacts();
            crmContacts5.setTel(tel);
            crmContacts5.setEmail(email);
            crmContacts5.setPwd(pwd);
            System.out.println(success());
            return toAjax(crmContactsService.insertCrmContacts(crmContacts5));
        }
        catch (AuthenticationException e)
        {
            return error();
        }

    }

    @GetMapping("/home/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return prefix + "/login";
    }
    @PostMapping("/home/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe, HttpSession session)
    {

        System.out.println(username+password+rememberMe);
        String msg = "用户或密码错误";
        try
        {
//            System.out.println(username);
            CrmContacts crmContacts = crmContactsService.selectCrmByLoginName(username);
            CrmContacts crmContacts1 = crmContactsService.selectCrmByTel(username);
            CrmContacts crmContacts2 = crmContactsService.selectCrmByEmail(username);
            if(crmContacts!=null){
                if(password.equals(crmContacts.getPwd())){
                    String crmname = crmContacts.getLoginName();
                    session.setAttribute("username1", crmname);
                }
            }else if(crmContacts1!=null){
                if(password.equals(crmContacts1.getPwd())){
                    String crmname = crmContacts1.getLoginName();
                    session.setAttribute("username1",crmname);
                }

            }else if(crmContacts2!=null){
                if(password.equals(crmContacts2.getPwd())){
                    String crmname = crmContacts2.getLoginName();
                    session.setAttribute("username1",crmname);
                }

            }else {
                return error(msg);
            }

            return success();
        }
        catch (AuthenticationException e)
        {
            return error(msg);
        }
    }

    @GetMapping("/home/appoint/{id}")
    public String appoint(@PathVariable("id") Long id, ModelMap mmap,HttpSession session)
    {

        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        List<CrmCar> cars = crmCarService.selectCrmCarAll();
        mmap.put("carid",id);
        mmap.put("cars",cars);
        return prefix + "/appoint";
    }
    @PostMapping("/home/appoint")
    @ResponseBody
    public AjaxResult ajaxAppoint(CrmAppoint crmAppoint)
    {
        if(crmAppoint.getTel()==null||crmAppoint.getTime()==null||crmAppoint.getName()==null||crmAppoint.getCarId()==null||
                "".equals(crmAppoint.getTel())||"".equals(crmAppoint.getName())){
            return error("请输入您的具体信息");
        }
        CrmContacts crmContacts =  crmContactsService.selectCrmByTel(crmAppoint.getTel());
        try {
            if (crmContacts!=null){ //联系人在数据库中，更新数据
                //更新联系人的名字
                CrmContacts crmContacts1 = new CrmContacts();
                crmContacts1.setId(crmContacts.getId());
                crmContacts1.setName(crmAppoint.getName());
                crmContacts1.setTel(crmAppoint.getTel());
                crmContactsService.updateCrmContacts(crmContacts1);

                //插入预约数据
                crmAppoint.setContactsId(crmContacts.getId());

                System.out.println(11111);
                CrmMessage crmMessage = new CrmMessage();
                crmMessage.setAddresseeId(crmContacts.getId());
                crmMessage.setTitle("预约成功");
                crmMessage.setMsg("预约");
                System.out.println(222222);
                crmMessageService.insertCrmMessageAuto(crmMessage);
                return toAjax(crmAppointService.insertCrmAppoint(crmAppoint));
            }else { //联系人不在数据库中，则插入数据
                //插入联系人数据
                CrmContacts crmContacts1 = new CrmContacts();
                crmContacts1.setName(crmAppoint.getName());
                crmContacts1.setTel(crmAppoint.getTel());
                crmContactsService.insertCrmContacts(crmContacts1);
                //插入预约数据
                crmContacts =  crmContactsService.selectCrmByTel(crmAppoint.getTel());
                crmAppoint.setContactsId(crmContacts.getId());

                System.out.println(11111);
                crmContacts =  crmContactsService.selectCrmByTel(crmAppoint.getTel());
                CrmMessage crmMessage = new CrmMessage();
                crmMessage.setAddresseeId(crmContacts.getId());
                crmMessage.setTitle("预约成功");
                crmMessage.setMsg("预约");
                System.out.println(222222);
                System.out.println(crmMessage);
                crmMessageService.insertCrmMessageAuto(crmMessage);
                return toAjax(crmAppointService.insertCrmAppoint(crmAppoint));
            }
        }catch (Exception e){
            return error();
        }
    }

    @PostMapping("/home/exit")
    @ResponseBody
    public String homeExit(HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        session.removeAttribute("username1");
        return "exit";

    }


    @GetMapping("/home/carModel")
    public String carAllModel(ModelMap mmap,HttpSession session)
    {
        //登录后，前端显示的用户名
        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        //显示左边汽车名
        List<CrmCarBrand> carBrandList = crmCarBrandService.selectCrmCarBrandList(new CrmCarBrand());
        mmap.put("carBrandList", carBrandList);

        //显示所有汽车
        int i = 0;
        List carlists = new ArrayList<>();
        List carPrice = new ArrayList<>();
        for(CrmCarBrand carBrand : carBrandList){
            String carBran = carBrand.getCarbrand();
            CrmCar crmCar = new CrmCar();
            crmCar.setName(carBran);
            List<CrmCar> carlist = crmCarService.selectCrmCarList(crmCar);
            carlists.add(i,carlist);

            List<Double> listprince = Lists.newArrayList(carlist.get(0).getPrice(), carlist.get(carlist.size()-1).getPrice());
            carPrice.add(i,listprince);
            System.out.println(carlist.get(0).getPrice());
            System.out.println(carlist.get(carlist.size()-1).getPrice());
            i++;
        }
//        System.out.println(carlists);
//        List<CrmCar> carlist = crmCarService.selectCrmCarhomeLimit();
        mmap.put("carAllPrince", carPrice);
        mmap.put("carAllModel", carlists);
        System.out.println(1111);
        return prefix + "/car-AllModels";
    }

    @GetMapping("/home/carModel/{carBrand}")
    public String carModel(@PathVariable("carBrand") String carBrand,ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        List<CrmCarBrand> carBrandList = crmCarBrandService.selectCrmCarBrandList(new CrmCarBrand());
        mmap.put("carBrandList", carBrandList);
        System.out.println(carBrand);

        List carlists = new ArrayList<>();
        CrmCar crmCar = new CrmCar();
        crmCar.setName(carBrand);
        List<CrmCar> carlist = crmCarService.selectCrmCarList(crmCar);
        carlists.add(0,carlist);

        List carPrice = new ArrayList<>();
        List<Double> listprince = Lists.newArrayList(carlist.get(0).getPrice(), carlist.get(carlist.size()-1).getPrice());
        carPrice.add(0,listprince);

        mmap.put("carAllPrince", carPrice);
        mmap.put("carAllModel", carlists);
        System.out.println(1111);
        return prefix + "/car-AllModels";

    }

    @GetMapping("/home/carDetail/{carId}")
    public String carAllDetail(@PathVariable("carId") Long carId,ModelMap mmap,HttpSession session)
    {
        //登录后，前端显示的用户名
        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        //显示左边汽车名
        List<CrmCarBrand> carBrandList = crmCarBrandService.selectCrmCarBrandList(new CrmCarBrand());
        mmap.put("carBrandList", carBrandList);

        //显示所有汽车
        CrmCar crmCar = crmCarService.selectCrmCarById(carId);
        mmap.put("crmDetail",crmCar);

        return prefix + "/car-Detail";
    }

    @GetMapping("/home/carFeedback")
    public String carFeedback(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        return prefix + "/car-Feedback";
    }
    @PostMapping("/home/carFeedback")
    @ResponseBody
    public AjaxResult ajaxFeedback(CrmMsgFeedback crmMsgFeedback,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        CrmContacts crmContacts =  crmContactsService.selectCrmByLoginName(username1);
        try{
            if(crmMsgFeedback.getMsg()==null||crmMsgFeedback.getTitle()==null ||
                    "".equals(crmMsgFeedback.getMsg()) ||"".equals(crmMsgFeedback.getTitle())){
                return error("请输入内容");
            }
            if(crmContacts==null){
                crmMsgFeedback.setAddresserId(999L);
            }else {
                crmMsgFeedback.setAddresserId(crmContacts.getId());
                CrmMessage crmMessage = new CrmMessage();
                crmMessage.setAddresseeId(crmContacts.getId());
                crmMessage.setTitle("反馈成功");
                crmMessage.setMsg("反馈");
                crmMessageService.insertCrmMessageAuto(crmMessage);
            }
            crmMsgFeedbackService.insertCrmMsgFeedback(crmMsgFeedback);

            return success();
        }catch (Exception e){
            return error();
        }
    }

    @GetMapping("/home/about")
    public String carAbout(ModelMap mmap,HttpSession session)
    {
        String username1=(String)session.getAttribute("username1");
        mmap.put("CrmName", username1);
        return prefix + "/about";
    }

}
