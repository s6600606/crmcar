package com.crm.web.controller.vue;

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
import com.crm.vue.domain.VueDetShopinfo;
import com.crm.vue.service.IVueDetShopinfoService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 商家店铺Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/shopinfo")
public class VueDetShopinfoController extends BaseController
{
    private String prefix = "vue/shopinfo";

    @Autowired
    private IVueDetShopinfoService vueDetShopinfoService;

    @RequiresPermissions("vue:shopinfo:view")
    @GetMapping()
    public String shopinfo()
    {
        return prefix + "/shopinfo";
    }

    /**
     * 查询商家店铺列表
     */
    @RequiresPermissions("vue:shopinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueDetShopinfo vueDetShopinfo)
    {
        startPage();
        List<VueDetShopinfo> list = vueDetShopinfoService.selectVueDetShopinfoList(vueDetShopinfo);
        return getDataTable(list);
    }

    /**
     * 导出商家店铺列表
     */
    @RequiresPermissions("vue:shopinfo:export")
    @Log(title = "商家店铺", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueDetShopinfo vueDetShopinfo)
    {
        List<VueDetShopinfo> list = vueDetShopinfoService.selectVueDetShopinfoList(vueDetShopinfo);
        ExcelUtil<VueDetShopinfo> util = new ExcelUtil<VueDetShopinfo>(VueDetShopinfo.class);
        return util.exportExcel(list, "shopinfo");
    }

    /**
     * 新增商家店铺
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商家店铺
     */
    @RequiresPermissions("vue:shopinfo:add")
    @Log(title = "商家店铺", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueDetShopinfo vueDetShopinfo)
    {
        return toAjax(vueDetShopinfoService.insertVueDetShopinfo(vueDetShopinfo));
    }

    /**
     * 修改商家店铺
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueDetShopinfo vueDetShopinfo = vueDetShopinfoService.selectVueDetShopinfoById(id);
        mmap.put("vueDetShopinfo", vueDetShopinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存商家店铺
     */
    @RequiresPermissions("vue:shopinfo:edit")
    @Log(title = "商家店铺", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueDetShopinfo vueDetShopinfo)
    {
        return toAjax(vueDetShopinfoService.updateVueDetShopinfo(vueDetShopinfo));
    }

    /**
     * 删除商家店铺
     */
    @RequiresPermissions("vue:shopinfo:remove")
    @Log(title = "商家店铺", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueDetShopinfoService.deleteVueDetShopinfoByIds(ids));
    }
}
