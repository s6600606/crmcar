package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueCatSubcategoryMapper;
import com.crm.vue.domain.VueCatSubcategory;
import com.crm.vue.service.IVueCatSubcategoryService;
import com.crm.common.core.text.Convert;

/**
 * 具体分类Service业务层处理
 * 
 * @author crm
 * @date 2020-08-04
 */
@Service
public class VueCatSubcategoryServiceImpl implements IVueCatSubcategoryService 
{
    @Autowired
    private VueCatSubcategoryMapper vueCatSubcategoryMapper;

    /**
     * 查询具体分类
     * 
     * @param id 具体分类ID
     * @return 具体分类
     */
    @Override
    public VueCatSubcategory selectVueCatSubcategoryById(Long id)
    {
        return vueCatSubcategoryMapper.selectVueCatSubcategoryById(id);
    }

    /**
     * 查询具体分类列表
     * 
     * @param vueCatSubcategory 具体分类
     * @return 具体分类
     */
    @Override
    public List<VueCatSubcategory> selectVueCatSubcategoryList(VueCatSubcategory vueCatSubcategory)
    {
        return vueCatSubcategoryMapper.selectVueCatSubcategoryList(vueCatSubcategory);
    }

    /**
     * 新增具体分类
     * 
     * @param vueCatSubcategory 具体分类
     * @return 结果
     */
    @Override
    public int insertVueCatSubcategory(VueCatSubcategory vueCatSubcategory)
    {
        return vueCatSubcategoryMapper.insertVueCatSubcategory(vueCatSubcategory);
    }

    /**
     * 修改具体分类
     * 
     * @param vueCatSubcategory 具体分类
     * @return 结果
     */
    @Override
    public int updateVueCatSubcategory(VueCatSubcategory vueCatSubcategory)
    {
        return vueCatSubcategoryMapper.updateVueCatSubcategory(vueCatSubcategory);
    }

    /**
     * 删除具体分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueCatSubcategoryByIds(String ids)
    {
        return vueCatSubcategoryMapper.deleteVueCatSubcategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除具体分类信息
     * 
     * @param id 具体分类ID
     * @return 结果
     */
    @Override
    public int deleteVueCatSubcategoryById(Long id)
    {
        return vueCatSubcategoryMapper.deleteVueCatSubcategoryById(id);
    }
}
