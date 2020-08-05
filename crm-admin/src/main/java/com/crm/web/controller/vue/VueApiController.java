package com.crm.web.controller.vue;

import com.crm.common.core.controller.BaseController;
import com.crm.common.core.page.TableDataInfo;
import com.crm.common.json.JSONObject;
import com.crm.vue.domain.*;
import com.crm.vue.service.*;
import org.apache.commons.collections.list.LazyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class VueApiController extends BaseController {
    @Autowired
    private IVueApiService vueApiService;
    @Autowired
    private IVueDetDetailinfoService vueDetDetailinfoService;
    @Autowired
    private IVueDetIteminfoService vueDetIteminfoService;
    @Autowired
    private IVueDetItemparamsService vueDetItemparamsService;
    @Autowired
    private IVueDetShopinfoService vueDetShopinfoService;
    @Autowired
    private IVueDetRateService vueDetRateService;
    @Autowired
    private IVueDetailService vueDetailService;
    @Autowired
    private IVueCategoryService vueCategoryService;
    @Autowired
    private IVueCatSubcategoryService vueCatSubcategoryService;

    @GetMapping("/home/multidata")
    @ResponseBody
    public Object getHomeMultidata()
    {
        String url = "http://123.207.32.32:8000/home/multidata";
        BufferedReader br = null;
        InputStream is = null;
        String backStr = "";
        StringBuilder sb = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(10000);
            conn.setRequestProperty("accept", "*/*");
            //接收结果
            is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            //缓冲逐行读取
            while ( ( line = br.readLine() ) != null )
            {
                sb.append(line);
            }
            backStr=sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Object object = JSON.parse(backStr);

        return object;
    }


    @GetMapping("/home/data")
    @ResponseBody
    public JSONObject getHomeData(String type, Long page)
    {
        type = "".equals(type)||type==null?"pop":type;
        page = "".equals(page)||page==null||page==0 ? 1:page;
        VueHomedata vueHomedata = new VueHomedata();
        vueHomedata.setType(type);
        vueHomedata.setPage1((page-1)*10);
        vueHomedata.setPage10(page*10);
        List<VueHomedata> list = vueApiService.ListHomedata(vueHomedata);

        JSONObject jsonlist = new JSONObject();
        jsonlist.put("list",list);
        JSONObject jsondata = new JSONObject();
        jsondata.put("data",jsonlist);
        return jsondata;
    }

    @GetMapping("/detail")
    @ResponseBody
    public JSONObject getDetail(Long iid)
    {
        System.out.println("iid==="+iid);
        if(iid==null||"".equals(iid)||iid==0){
            iid = 1L;
        }
        VueDetail vueDetail = vueDetailService.selectVueDetailById(iid);

        VueDetIteminfo jsonItemInfo = getItemInfo(vueDetail.getIteminfoId());
        VueDetShopinfo jsonShopinfo = getShopInfo(vueDetail.getShopinfoId());
        VueDetDetailinfo jsonDetailInfo = getDetailInfo(vueDetail.getDetailinfoId());
        JSONObject jsonItemParams = getItemParams(vueDetail.getItemparamsId());
        JSONObject jsonRate = getRate(vueDetail.getRateId());
//        System.out.println(jsonItemInfo);

        List<String> columns = new ArrayList<>();
        columns.add(0,"zero");
        columns.add(1,"first");

        //测试
        String topImg = jsonItemInfo.getTopImages();
        String[] stringArray = topImg.split(",");
        List<String> list = Arrays.asList(stringArray);
        jsonItemInfo.setListimg(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("itemInfo",jsonItemInfo);
        jsonObject.put("shopInfo",jsonShopinfo);
        jsonObject.put("detailInfo",jsonDetailInfo);
        jsonObject.put("itemParams",jsonItemParams);
        jsonObject.put("rate",jsonRate);
        jsonObject.put("columns",columns);

        JSONObject jsondata = new JSONObject();
        jsondata.put("result",jsonObject);
        return jsondata;
    }
    public VueDetIteminfo getItemInfo(Long id)
    {
        VueDetIteminfo vueDetIteminfo = vueDetIteminfoService.selectVueDetIteminfoById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("itemInfo",vueDetIteminfo);
        return vueDetIteminfo;
    }
    public VueDetShopinfo getShopInfo(Long id)
    {
        VueDetShopinfo vueDetShopinfo = vueDetShopinfoService.selectVueDetShopinfoById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("shopInfo",vueDetShopinfo);
        return vueDetShopinfo;
    }
    public VueDetDetailinfo getDetailInfo(Long id)
    {
        VueDetDetailinfo vueDetDetailinfo = vueDetDetailinfoService.selectVueDetDetailinfoById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("detailInfo",vueDetDetailinfo);
        return vueDetDetailinfo;
    }
    public JSONObject getItemParams(Long id)
    {
        VueDetItemparams vueDetItemparams = vueDetItemparamsService.ListVueDetItemparams(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("images",vueDetItemparams.getImages());
        jsonObject.put("set",vueDetItemparams.getSet());
//        JSONObject jsonObjectinfo = new JSONObject();

        System.out.println(jsonObject);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("tables",vueDetItemparams.getTables());
//        JSONObject jsonObjectrule = new JSONObject();


        JSONObject jsondata = new JSONObject();
        jsondata.put("info",jsonObject);
        jsondata.put("rule",jsonObject1);
//        jsondata.put("itemParams",jsonObjectinfo);
        return jsondata;
    }
    public JSONObject getRate(Long id)
    {
        VueDetRate vueDetRate = vueDetRateService.selectVueDetRateById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",vueDetRate);
        return jsonObject;
    }


    @GetMapping("/recommend")
    @ResponseBody
    public JSONObject getRecommend()
    {
        VueHomedata vueHomedata = new VueHomedata();
        List<VueHomedata> list = vueApiService.ListHomedata(vueHomedata);

        JSONObject jsonlist = new JSONObject();
        jsonlist.put("list",list);
        JSONObject jsondata = new JSONObject();
        jsondata.put("data",jsonlist);
        return jsondata;
    }

    @GetMapping("/category")
    @ResponseBody
    public JSONObject getCategory()
    {

        VueCategory vueCategory = new VueCategory();
        List<VueCategory> list = vueCategoryService.selectVueCategoryList(vueCategory);

        JSONObject jsonlist = new JSONObject();
        jsonlist.put("list",list);
        JSONObject jsoncat = new JSONObject();
        jsoncat.put("category",jsonlist);
        JSONObject jsondata = new JSONObject();
        jsondata.put("data",jsoncat);
        return jsondata;
    }

    @GetMapping("/subcategory")
    @ResponseBody
    public JSONObject getSubcategory(String maitKey)
    {

        VueCatSubcategory vueCatSubcategory = new VueCatSubcategory();
        List<VueCatSubcategory> list = vueCatSubcategoryService.selectVueCatSubcategoryList(vueCatSubcategory);
        JSONObject jsonlist = new JSONObject();
        jsonlist.put("list",list);
        JSONObject jsoncat = new JSONObject();
        jsoncat.put("category",jsonlist);
        JSONObject jsondata = new JSONObject();
        jsondata.put("data",jsoncat);
        return jsondata;
    }

    @GetMapping("/subcategory/detail")
    @ResponseBody
    public JSONObject getCategoryDetail(Long miniWallkey,String type)
    {
        type = "".equals(type)||type==null?"pop":type;
        miniWallkey = "".equals(miniWallkey)||miniWallkey==null ? 1:miniWallkey;

        VueHomedata vueHomedata = new VueHomedata();
        vueHomedata.setType(type);
        vueHomedata.setMiniWallkey(miniWallkey);
        List<VueHomedata> list = vueApiService.ListHomedata(vueHomedata);

        JSONObject jsonlist = new JSONObject();
        jsonlist.put("list",list);
        return jsonlist;
    }
}
