package com.crm.web.controller.crm;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPObject;
import com.google.common.collect.Lists;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.BaseEntity;
import com.crm.common.json.JSON;
import com.crm.common.json.JSONObject;
import com.crm.crm.domain.CrmCar;
import com.crm.crm.domain.CrmCarBrand;
import com.crm.crm.domain.CrmOrderStandard;
import com.crm.crm.domain.CrmOrderform;
import com.crm.crm.service.ICrmMsgFeedbackService;
import com.crm.crm.service.ICrmOrderStandardService;
import com.crm.crm.service.ICrmOrderformService;
import com.crm.system.domain.SysUser;
import com.crm.system.service.ISysUserService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/crm/orderform")
public class CrmOrderformController extends BaseController
{
    private String prefix = "crm/orderform";

    @Autowired
    private ICrmOrderformService crmOrderformService;
    @Autowired
    private ICrmOrderStandardService crmOrderStandardService;
    @Autowired
    private ISysUserService sysUserService;



    @RequiresPermissions("crm:orderform:view")
    @GetMapping()
    public String orderform(ModelMap mmap)
    {
//        System.out.println(1111);
        List<CrmOrderform> list = crmOrderformService.selectCrmOrderformList(new CrmOrderform());
//        System.out.println(list);
        mmap.put("crmOrderform",list);
        return prefix + "/orderform";
    }

    @PostMapping("/month")
    @ResponseBody
    public JSONObject ordermonth(Date month, ModelMap modelMap)
    {
        System.out.println(month);

        if(month==null||"".equals(month)){
            //获取本月的第一天
            month = Getmonth();
        }
        Date nextDay;
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //HH表示24小时制；
        CrmOrderform crmOrderform = new CrmOrderform();
        int monthcount = 0;     //本月订单数
        int lastmonthcount = 0; //上月订单数
        double lastmonthPrice = 0;  //上月总销售额
        double monthAllPrice = 0;   //本月总销售额
        double dayPrice = 0;    //每日销售额
        List<Double> monthPrice = new ArrayList<>();    //月销售：每日销售额数组
        List<String> monthNum = new ArrayList<>();  //这个月有多少天

        //下个月
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(month);
        int monthdays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   //获取某月的天数
        for(int i = 1;i<=monthdays;i++){
            monthNum.add(i+"日");
        }
        calendar.add(Calendar.MONTH, 1);
        Date nextMonth = calendar.getTime().getTime() <= (new Date()).getTime() ? calendar.getTime(): new Date();

        //上个月和本月的总销售额
        calendar.add(Calendar.MONTH,-2);
        Date lastMonth = calendar.getTime();
        System.out.println(dFormat.format(lastMonth));
        modelMap.put("beginTime",dFormat.format(lastMonth));
        modelMap.put("endTime",dFormat.format(month));
        crmOrderform.setParams(modelMap);
        CrmOrderform orderform00 = crmOrderformService.selectCrmOrderformPrice(crmOrderform);
        lastmonthPrice = orderform00.getSum()!=null&&orderform00.getSum()>0  ? orderform00.getSum() : 0;
        lastmonthcount+= orderform00.getCount()!=null&&orderform00.getCount()>0  ? orderform00.getCount() : 0;

        //用于循环的下一天
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(month);


        //循环，从选中月~下个月
        while (month.getTime()<nextMonth.getTime()){
            //加一天
            calendar1.add(Calendar.DATE,1);
            nextDay = calendar1.getTime();

            //时间范围
            modelMap.put("beginTime",dFormat.format(month));
            modelMap.put("endTime",dFormat.format(nextDay));
            crmOrderform.setParams(modelMap);

            //数据库操作
            CrmOrderform orderform = crmOrderformService.selectCrmOrderformPrice(crmOrderform);
            monthcount+= orderform.getCount()!=null&&orderform.getCount()>0  ? orderform.getCount() : 0;    //月订单数累计
            dayPrice = orderform.getSum()!=null&&orderform.getSum()>0  ? orderform.getSum() : 0;    //一个月的每日销售额
            monthAllPrice+=dayPrice;    //月总销售额
            monthPrice.add(dayPrice);

            month = nextDay;
        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("月销售",monthPrice);
        jsonObject.put("天数",monthNum);
        jsonObject.put("上销售额",lastmonthPrice);
        jsonObject.put("本销售额",monthAllPrice);
        jsonObject.put("本订单数",monthcount);
        jsonObject.put("上订单数",lastmonthcount);
//        System.out.println(jsonObject);
        return jsonObject;
    }

    @PostMapping("/year")
    @ResponseBody
    public JSONObject orderyear(Date year, ModelMap modelMap)
    {
        System.out.println("本年：");
        System.out.println(year);

        if(year==null||"".equals(year)){
            //获取本月的第一天
            Calendar   cal_1=Calendar.getInstance();//获取当前日期
            cal_1.add(Calendar.YEAR, 0);
            cal_1.set(Calendar.MONTH,0);
            cal_1.set(Calendar.DAY_OF_MONTH,1);
            year = cal_1.getTime();
        }
        Date nextMonth;
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        CrmOrderform crmOrderform = new CrmOrderform();
        int yearcount = 0;     //本年订单数
        int lastyearcount = 0;  //上年订单数
        double lastyearPrice = 0;  //上年总销售额
        double yearAllPrice = 0;   //本年总销售额
        double monthPrice = 0;    //每日销售额
        List<Double> yearPrice = new ArrayList<>();    //年销售：每月销售额数组
        List<String> yearNum = new ArrayList<>();  //一年12个月

        //下一年
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(year);
        for(int i = 1;i<=12;i++){
            yearNum.add(i+"月");
        }
        calendar.add(Calendar.YEAR, 1);
        Date nextYear = calendar.getTime().getTime() <= (new Date()).getTime() ? calendar.getTime(): new Date();

        //上一年和本年的总销售额
        calendar.add(Calendar.YEAR,-2);
        Date lastYear = calendar.getTime();
        modelMap.put("beginTime",dFormat.format(lastYear));
        modelMap.put("endTime",dFormat.format(year));
        crmOrderform.setParams(modelMap);
        CrmOrderform orderform00 = crmOrderformService.selectCrmOrderformPrice(crmOrderform);
        lastyearPrice = orderform00.getSum()!=null&&orderform00.getSum()>0  ? orderform00.getSum() : 0;
        lastyearcount += orderform00.getCount()!=null&&orderform00.getCount()>0  ? orderform00.getCount() : 0;
        //用于循环的下一天
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(year);


        //循环，从选中月~下个月
        while (year.getTime()<nextYear.getTime()){
            //加一天
            calendar1.add(Calendar.MONTH,1);
            nextMonth = calendar1.getTime();

            //时间范围
            modelMap.put("beginTime",dFormat.format(year));
            modelMap.put("endTime",dFormat.format(nextMonth));
            crmOrderform.setParams(modelMap);

            //数据库操作
            CrmOrderform orderform = crmOrderformService.selectCrmOrderformPrice(crmOrderform);
            yearcount+= orderform.getCount()!=null&&orderform.getCount()>0  ? orderform.getCount() : 0;    //月订单数累计
            monthPrice = orderform.getSum()!=null&&orderform.getSum()>0  ? orderform.getSum() : 0;    //一个月的每日销售额
            yearAllPrice+=monthPrice;    //月总销售额
            yearPrice.add(monthPrice);

            year = nextMonth;
        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("年销售",yearPrice);
        jsonObject.put("月数",yearNum);
        jsonObject.put("上销售额",lastyearPrice);
        jsonObject.put("本销售额",yearAllPrice);
        jsonObject.put("本订单数",yearcount);
        jsonObject.put("上订单数",lastyearcount);
        System.out.println(jsonObject);
        return jsonObject;
    }

    @PostMapping("/rightdate")
    @ResponseBody
    public JSONObject rightdate(String rightdate)
    {

        CrmOrderStandard crmOrderStandard = crmOrderStandardService.selectCrmOrderStandardById(1L);
        JSONObject jsonObject = new JSONObject();
        if("月".equals(rightdate)){
            jsonObject.put("销售额",crmOrderStandard.getMonthAmount());
            jsonObject.put("订单数",crmOrderStandard.getMonthOrder());
        }else if("年".equals(rightdate)){
            jsonObject.put("销售额",crmOrderStandard.getYearAmount());
            jsonObject.put("订单数",crmOrderStandard.getYearOrder());
        }
        jsonObject.put("个人销售额",crmOrderStandard.getMonthAamount());
        jsonObject.put("个人订单数",crmOrderStandard.getMonthAorder());

//        System.out.println(jsonObject);
        return jsonObject;
    }


    @PostMapping("/salemonth")
    @ResponseBody
    public JSONObject salemonth(Date month, ModelMap modelMap)
    {
        if(month==null||"".equals(month)){
            //获取本月的第一天
            month = Getmonth();
        }

        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //HH表示24小时制；
        CrmOrderform crmOrderform = new CrmOrderform();

        double monthAllPrice = 0;   //本月总销售额
        List<Double> monthPrice = new ArrayList<>();    //月销售：每日销售额数组

        //下个月
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(month);
        calendar.add(Calendar.MONTH, 1);
        Date nextMonth = calendar.getTime().getTime() <= (new Date()).getTime() ? calendar.getTime(): new Date();
        modelMap.put("beginTime",dFormat.format(month));
        modelMap.put("endTime",dFormat.format(nextMonth));
        crmOrderform.setParams(modelMap);

        List<String> saleNum = new ArrayList<>();  //这个月有多少天
        List<SysUser> sysUserList = sysUserService.selectUserAll();
        for(SysUser sysUser:sysUserList){
            saleNum.add(sysUser.getUserName());
            crmOrderform.setSalesperson(sysUser.getUserName());
            CrmOrderform orderform00 = crmOrderformService.selectCrmOrderformPrice(crmOrderform);
            monthAllPrice = orderform00.getSum()!=null&&orderform00.getSum()>0  ? orderform00.getSum() : 0;
            monthPrice.add(monthAllPrice);
        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("月销售",monthPrice);
        jsonObject.put("人",saleNum);
        System.out.println(jsonObject);
        return jsonObject;
    }

    //获取本月第一天
    public Date Getmonth(){
        Date month;
        Calendar cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        month = cal_1.getTime();
        return month;
    }
}
