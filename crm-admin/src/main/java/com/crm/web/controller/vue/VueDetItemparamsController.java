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
import com.crm.vue.domain.VueDetItemparams;
import com.crm.vue.service.IVueDetItemparamsService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 商品参数Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/itemparams")
public class VueDetItemparamsController extends BaseController
{
    private String prefix = "vue/itemparams";

    @Autowired
    private IVueDetItemparamsService vueDetItemparamsService;

    @RequiresPermissions("vue:itemparams:view")
    @GetMapping()
    public String itemparams()
    {
        return prefix + "/itemparams";
    }

    /**
     * 查询商品参数列表
     */
    @RequiresPermissions("vue:itemparams:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueDetItemparams vueDetItemparams)
    {
        startPage();
        List<VueDetItemparams> list = vueDetItemparamsService.selectVueDetItemparamsList(vueDetItemparams);
        return getDataTable(list);
    }

    /**
     * 导出商品参数列表
     */
    @RequiresPermissions("vue:itemparams:export")
    @Log(title = "商品参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueDetItemparams vueDetItemparams)
    {
        List<VueDetItemparams> list = vueDetItemparamsService.selectVueDetItemparamsList(vueDetItemparams);
        ExcelUtil<VueDetItemparams> util = new ExcelUtil<VueDetItemparams>(VueDetItemparams.class);
        return util.exportExcel(list, "itemparams");
    }

    /**
     * 新增商品参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品参数
     */
    @RequiresPermissions("vue:itemparams:add")
    @Log(title = "商品参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueDetItemparams vueDetItemparams)
    {
        return toAjax(vueDetItemparamsService.insertVueDetItemparams(vueDetItemparams));
    }

    /**
     * 修改商品参数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueDetItemparams vueDetItemparams = vueDetItemparamsService.selectVueDetItemparamsById(id);
        mmap.put("vueDetItemparams", vueDetItemparams);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品参数
     */
    @RequiresPermissions("vue:itemparams:edit")
    @Log(title = "商品参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueDetItemparams vueDetItemparams)
    {
        return toAjax(vueDetItemparamsService.updateVueDetItemparams(vueDetItemparams));
    }

    /**
     * 删除商品参数
     */
    @RequiresPermissions("vue:itemparams:remove")
    @Log(title = "商品参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueDetItemparamsService.deleteVueDetItemparamsByIds(ids));
    }
}
