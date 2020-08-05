package com.crm.web.controller.vue;

import java.util.List;

import com.crm.common.annotation.Log;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.core.page.TableDataInfo;
import com.crm.common.enums.BusinessType;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.vue.domain.VueDetIteminfo;
import com.crm.vue.service.IVueDetIteminfoService;
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
@RequestMapping("/vue/iteminfo")
public class VueDetIteminfoController extends BaseController
{
    private String prefix = "vue/iteminfo";

    @Autowired
    private IVueDetIteminfoService vueDetIteminfoService;

    @RequiresPermissions("vue:iteminfo:view")
    @GetMapping()
    public String iteminfo()
    {
        return prefix + "/iteminfo";
    }

    /**
     * 查询商品信息列表
     */
    @RequiresPermissions("vue:iteminfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueDetIteminfo vueDetIteminfo)
    {
        startPage();
        List<VueDetIteminfo> list = vueDetIteminfoService.selectVueDetIteminfoList(vueDetIteminfo);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @RequiresPermissions("vue:iteminfo:export")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueDetIteminfo vueDetIteminfo)
    {
        List<VueDetIteminfo> list = vueDetIteminfoService.selectVueDetIteminfoList(vueDetIteminfo);
        ExcelUtil<VueDetIteminfo> util = new ExcelUtil<VueDetIteminfo>(VueDetIteminfo.class);
        return util.exportExcel(list, "iteminfo");
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
    @RequiresPermissions("vue:iteminfo:add")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueDetIteminfo vueDetIteminfo)
    {
        return toAjax(vueDetIteminfoService.insertVueDetIteminfo(vueDetIteminfo));
    }

    /**
     * 修改商品信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueDetIteminfo vueDetIteminfo = vueDetIteminfoService.selectVueDetIteminfoById(id);
        mmap.put("vueDetIteminfo", vueDetIteminfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品信息
     */
    @RequiresPermissions("vue:iteminfo:edit")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueDetIteminfo vueDetIteminfo)
    {
        return toAjax(vueDetIteminfoService.updateVueDetIteminfo(vueDetIteminfo));
    }

    /**
     * 删除商品信息
     */
    @RequiresPermissions("vue:iteminfo:remove")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueDetIteminfoService.deleteVueDetIteminfoByIds(ids));
    }
}
