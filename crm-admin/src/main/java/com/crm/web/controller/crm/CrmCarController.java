package com.crm.web.controller.crm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.common.config.Global;
import com.crm.common.config.ServerConfig;
import com.crm.common.utils.file.FileUploadUtils;
import com.crm.crm.domain.CrmCarBrand;
import com.crm.crm.service.ICrmCarBrandService;
import com.crm.framework.util.ShiroUtils;
import com.crm.system.domain.SysUser;
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
import com.crm.crm.domain.CrmCar;
import com.crm.crm.service.ICrmCarService;
import com.crm.common.core.controller.BaseController;
import com.crm.common.core.domain.AjaxResult;
import com.crm.common.utils.poi.ExcelUtil;
import com.crm.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * carController
 * 
 * @author crm
 * @date 2020-03-06
 */
@Controller
@RequestMapping("/crm/car")
public class CrmCarController extends BaseController
{
    @Autowired
    private ServerConfig serverConfig;

    private String prefix = "crm/car";

    @Autowired
    private ICrmCarService crmCarService;
    @Autowired
    private ICrmCarBrandService crmCarBrandService;

    @RequiresPermissions("crm:car:view")
    @GetMapping()
    public String car()
    {
        return prefix + "/car";
    }

    /**
     * 查询car列表
     */
    @RequiresPermissions("crm:car:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrmCar crmCar)
    {
        startPage();
        List<CrmCar> list = crmCarService.selectCrmCarList(crmCar);
//        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 导出car列表
     */
    @RequiresPermissions("crm:car:export")
    @Log(title = "car", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmCar crmCar)
    {
        List<CrmCar> list = crmCarService.selectCrmCarList(crmCar);
        ExcelUtil<CrmCar> util = new ExcelUtil<CrmCar>(CrmCar.class);
        return util.exportExcel(list, "car");
    }

    /**
     * 新增car
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        CrmCarBrand crmCarBrand = new CrmCarBrand();
        List<CrmCarBrand> list =  crmCarBrandService.selectCrmCarBrandList(crmCarBrand);
        mmap.put("carBrandss",list);
        return prefix + "/add";
    }

    /**
     * 新增保存car
     */
    @RequiresPermissions("crm:car:add")
    @Log(title = "car", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrmCar crmCar)
    {
        return toAjax(crmCarService.insertCrmCar(crmCar));
    }

    /**
     * 修改car
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrmCarBrand crmCarBrand = new CrmCarBrand();
        List<CrmCarBrand> list =  crmCarBrandService.selectCrmCarBrandList(crmCarBrand);
        mmap.put("carBrandss",list);
        CrmCar crmCar = crmCarService.selectCrmCarById(id);
        mmap.put("crmCar", crmCar);
        return prefix + "/edit";
    }

    /**
     * 修改保存car
     */
    @RequiresPermissions("crm:car:edit")
    @Log(title = "car", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrmCar crmCar)
    {
        return toAjax(crmCarService.updateCrmCar(crmCar));
    }

    /**
     * 上传图片
     */
    @PostMapping("/uploadCar")
    @ResponseBody
    public AjaxResult uploadCar(MultipartFile file) throws Exception
    {
        try
        {
            // 上传并返回新文件名称
            String path = FileUploadUtils.upload(Global.getCarPath(), file);
            String url = serverConfig.getUrl() + path;
            Map<String,Object> data=new HashMap();
            data.put("path",path);
            data.put("url",url);
            data.put("suffix",FileUploadUtils.getExtension(file));
            data.put("size",file.getSize());
            data.put("name",file.getOriginalFilename());
            return AjaxResult.success(data);
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 删除car
     */
    @RequiresPermissions("crm:car:remove")
    @Log(title = "car", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crmCarService.deleteCrmCarByIds(ids));
    }


}
