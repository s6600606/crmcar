package com.crm.web.controller.vue;

import java.util.List;

import com.crm.common.annotation.Log;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.core.page.TableDataInfo;
import com.crm.common.enums.BusinessType;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.vue.domain.VueDetail;
import com.crm.vue.service.IVueDetailService;
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
 * 商品详情Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/detail")
public class VueDetailController extends BaseController
{
    private String prefix = "vue/detail";

    @Autowired
    private IVueDetailService vueDetailService;

    @RequiresPermissions("vue:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/detail";
    }

    /**
     * 查询商品详情列表
     */
    @RequiresPermissions("vue:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueDetail vueDetail)
    {
        startPage();
        List<VueDetail> list = vueDetailService.selectVueDetailList(vueDetail);
        return getDataTable(list);
    }

    /**
     * 导出商品详情列表
     */
    @RequiresPermissions("vue:detail:export")
    @Log(title = "商品详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueDetail vueDetail)
    {
        List<VueDetail> list = vueDetailService.selectVueDetailList(vueDetail);
        ExcelUtil<VueDetail> util = new ExcelUtil<VueDetail>(VueDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增商品详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品详情
     */
    @RequiresPermissions("vue:detail:add")
    @Log(title = "商品详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueDetail vueDetail)
    {
        return toAjax(vueDetailService.insertVueDetail(vueDetail));
    }

    /**
     * 修改商品详情
     */
    @GetMapping("/edit/{iid}")
    public String edit(@PathVariable("iid") Long iid, ModelMap mmap)
    {
        VueDetail vueDetail = vueDetailService.selectVueDetailById(iid);
        mmap.put("vueDetail", vueDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品详情
     */
    @RequiresPermissions("vue:detail:edit")
    @Log(title = "商品详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueDetail vueDetail)
    {
        return toAjax(vueDetailService.updateVueDetail(vueDetail));
    }

    /**
     * 删除商品详情
     */
    @RequiresPermissions("vue:detail:remove")
    @Log(title = "商品详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueDetailService.deleteVueDetailByIds(ids));
    }
}
