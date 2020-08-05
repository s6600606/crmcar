package com.crm.web.controller.vue;

import java.util.List;

import com.crm.common.annotation.Log;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.core.page.TableDataInfo;
import com.crm.common.enums.BusinessType;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.vue.domain.VueDetDetailinfo;
import com.crm.vue.service.IVueDetDetailinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品信息Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/detailinfo")
public class VueDetDetailinfoController extends BaseController
{
    private String prefix = "vue/detailinfo";

    @Autowired
    private IVueDetDetailinfoService vueDetDetailinfoService;

    @RequiresPermissions("vue:detailinfo:view")
    @GetMapping()
    public String detailinfo()
    {
        return prefix + "/detailinfo";
    }

    /**
     * 查询商品信息列表
     */
    @RequiresPermissions("vue:detailinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueDetDetailinfo vueDetDetailinfo)
    {
        startPage();
        List<VueDetDetailinfo> list = vueDetDetailinfoService.selectVueDetDetailinfoList(vueDetDetailinfo);
        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @RequiresPermissions("vue:detailinfo:export")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueDetDetailinfo vueDetDetailinfo)
    {
        List<VueDetDetailinfo> list = vueDetDetailinfoService.selectVueDetDetailinfoList(vueDetDetailinfo);
        ExcelUtil<VueDetDetailinfo> util = new ExcelUtil<VueDetDetailinfo>(VueDetDetailinfo.class);
        return util.exportExcel(list, "detailinfo");
    }

    /**
     * 新增商品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品信息
     */
    @RequiresPermissions("vue:detailinfo:add")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueDetDetailinfo vueDetDetailinfo)
    {
        return toAjax(vueDetDetailinfoService.insertVueDetDetailinfo(vueDetDetailinfo));
    }

    /**
     * 修改商品信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueDetDetailinfo vueDetDetailinfo = vueDetDetailinfoService.selectVueDetDetailinfoById(id);
        mmap.put("vueDetDetailinfo", vueDetDetailinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品信息
     */
    @RequiresPermissions("vue:detailinfo:edit")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueDetDetailinfo vueDetDetailinfo)
    {
        return toAjax(vueDetDetailinfoService.updateVueDetDetailinfo(vueDetDetailinfo));
    }

    /**
     * 删除商品信息
     */
    @RequiresPermissions("vue:detailinfo:remove")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueDetDetailinfoService.deleteVueDetDetailinfoByIds(ids));
    }
}
