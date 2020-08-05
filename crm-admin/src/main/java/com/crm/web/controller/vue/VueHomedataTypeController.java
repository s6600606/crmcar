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
import com.crm.vue.domain.VueHomedataType;
import com.crm.vue.service.IVueHomedataTypeService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;

/**
 * 商品类型Controller
 * 
 * @author crm
 * @date 2020-07-31
 */
@Controller
@RequestMapping("/vue/type")
public class VueHomedataTypeController extends BaseController
{
    private String prefix = "vue/type";

    @Autowired
    private IVueHomedataTypeService vueHomedataTypeService;

    @RequiresPermissions("vue:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询商品类型列表
     */
    @RequiresPermissions("vue:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VueHomedataType vueHomedataType)
    {
        startPage();
        List<VueHomedataType> list = vueHomedataTypeService.selectVueHomedataTypeList(vueHomedataType);
        return getDataTable(list);
    }

    /**
     * 导出商品类型列表
     */
    @RequiresPermissions("vue:type:export")
    @Log(title = "商品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VueHomedataType vueHomedataType)
    {
        List<VueHomedataType> list = vueHomedataTypeService.selectVueHomedataTypeList(vueHomedataType);
        ExcelUtil<VueHomedataType> util = new ExcelUtil<VueHomedataType>(VueHomedataType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增商品类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品类型
     */
    @RequiresPermissions("vue:type:add")
    @Log(title = "商品类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VueHomedataType vueHomedataType)
    {
        return toAjax(vueHomedataTypeService.insertVueHomedataType(vueHomedataType));
    }

    /**
     * 修改商品类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VueHomedataType vueHomedataType = vueHomedataTypeService.selectVueHomedataTypeById(id);
        mmap.put("vueHomedataType", vueHomedataType);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品类型
     */
    @RequiresPermissions("vue:type:edit")
    @Log(title = "商品类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VueHomedataType vueHomedataType)
    {
        return toAjax(vueHomedataTypeService.updateVueHomedataType(vueHomedataType));
    }

    /**
     * 删除商品类型
     */
    @RequiresPermissions("vue:type:remove")
    @Log(title = "商品类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vueHomedataTypeService.deleteVueHomedataTypeByIds(ids));
    }
}
