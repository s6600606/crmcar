package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueCategoryMapper;
import com.crm.vue.domain.VueCategory;
import com.crm.vue.service.IVueCategoryService;
import com.crm.common.core.text.Convert;

/**
 * 分类Service业务层处理
 * 
 * @author crm
 * @date 2020-08-04
 */
@Service
public class VueCategoryServiceImpl implements IVueCategoryService 
{
    @Autowired
    private VueCategoryMapper vueCategoryMapper;

    /**
     * 查询分类
     * 
     * @param id 分类ID
     * @return 分类
     */
    @Override
    public VueCategory selectVueCategoryById(Long id)
    {
        return vueCategoryMapper.selectVueCategoryById(id);
    }

    /**
     * 查询分类列表
     * 
     * @param vueCategory 分类
     * @return 分类
     */
    @Override
    public List<VueCategory> selectVueCategoryList(VueCategory vueCategory)
    {
        return vueCategoryMapper.selectVueCategoryList(vueCategory);
    }

    /**
     * 新增分类
     * 
     * @param vueCategory 分类
     * @return 结果
     */
    @Override
    public int insertVueCategory(VueCategory vueCategory)
    {
        return vueCategoryMapper.insertVueCategory(vueCategory);
    }

    /**
     * 修改分类
     * 
     * @param vueCategory 分类
     * @return 结果
     */
    @Override
    public int updateVueCategory(VueCategory vueCategory)
    {
        return vueCategoryMapper.updateVueCategory(vueCategory);
    }

    /**
     * 删除分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueCategoryByIds(String ids)
    {
        return vueCategoryMapper.deleteVueCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分类信息
     * 
     * @param id 分类ID
     * @return 结果
     */
    @Override
    public int deleteVueCategoryById(Long id)
    {
        return vueCategoryMapper.deleteVueCategoryById(id);
    }
}
