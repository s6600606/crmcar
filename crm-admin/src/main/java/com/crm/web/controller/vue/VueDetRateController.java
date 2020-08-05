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
import com.crm.vue.domain.VueDetRate;
import com.crm.vue.service.IVueDetRateService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/rate")
public class VueDetRateController extends BaseController
{
    private String prefix = "vue/rate";

    @Autowired
    private IVueDetRateService vueDetRateService;

    @RequiresPermissions("vue:rate:view")
    @GetMapping()
    public String rate()
    {
        return prefix + "/rate";
    }

    /**
     * 查询评论列表
     */
    @RequiresPermissions("vue:rate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueDetRate vueDetRate)
    {
        startPage();
        List<VueDetRate> list = vueDetRateService.selectVueDetRateList(vueDetRate);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @RequiresPermissions("vue:rate:export")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueDetRate vueDetRate)
    {
        List<VueDetRate> list = vueDetRateService.selectVueDetRateList(vueDetRate);
        ExcelUtil<VueDetRate> util = new ExcelUtil<VueDetRate>(VueDetRate.class);
        return util.exportExcel(list, "rate");
    }

    /**
     * 新增评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论
     */
    @RequiresPermissions("vue:rate:add")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueDetRate vueDetRate)
    {
        return toAjax(vueDetRateService.insertVueDetRate(vueDetRate));
    }

    /**
     * 修改评论
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueDetRate vueDetRate = vueDetRateService.selectVueDetRateById(id);
        mmap.put("vueDetRate", vueDetRate);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论
     */
    @RequiresPermissions("vue:rate:edit")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueDetRate vueDetRate)
    {
        return toAjax(vueDetRateService.updateVueDetRate(vueDetRate));
    }

    /**
     * 删除评论
     */
    @RequiresPermissions("vue:rate:remove")
    @Log(title = "评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueDetRateService.deleteVueDetRateByIds(ids));
    }
}
