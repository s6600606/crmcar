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
import com.crm.vue.domain.VueHomedata;
import com.crm.vue.service.IVueHomedataService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 商品表Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/homedata")
public class VueHomedataController extends BaseController
{
    private String prefix = "vue/homedata";

    @Autowired
    private IVueHomedataService vueHomedataService;

    @RequiresPermissions("vue:homedata:view")
    @GetMapping()
    public String homedata()
    {
        return prefix + "/homedata";
    }

    /**
     * 查询商品表列表
     */
    @RequiresPermissions("vue:homedata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueHomedata vueHomedata)
    {
        startPage();
        List<VueHomedata> list = vueHomedataService.selectVueHomedataList(vueHomedata);
        return getDataTable(list);
    }

    /**
     * 导出商品表列表
     */
    @RequiresPermissions("vue:homedata:export")
    @Log(title = "商品表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueHomedata vueHomedata)
    {
        List<VueHomedata> list = vueHomedataService.selectVueHomedataList(vueHomedata);
        ExcelUtil<VueHomedata> util = new ExcelUtil<VueHomedata>(VueHomedata.class);
        return util.exportExcel(list, "homedata");
    }

    /**
     * 新增商品表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品表
     */
    @RequiresPermissions("vue:homedata:add")
    @Log(title = "商品表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueHomedata vueHomedata)
    {
        return toAjax(vueHomedataService.insertVueHomedata(vueHomedata));
    }

    /**
     * 修改商品表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueHomedata vueHomedata = vueHomedataService.selectVueHomedataById(id);
        mmap.put("vueHomedata", vueHomedata);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品表
     */
    @RequiresPermissions("vue:homedata:edit")
    @Log(title = "商品表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueHomedata vueHomedata)
    {
        return toAjax(vueHomedataService.updateVueHomedata(vueHomedata));
    }

    /**
     * 删除商品表
     */
    @RequiresPermissions("vue:homedata:remove")
    @Log(title = "商品表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueHomedataService.deleteVueHomedataByIds(ids));
    }
}
