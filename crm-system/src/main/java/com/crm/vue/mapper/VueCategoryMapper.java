package com.crm.vue.mapper;

import java.util.List;
import com.crm.vue.domain.VueCategory;

/**
 * 分类Mapper接口
 * 
 * @author crm
 * @date 2020-08-04
 */
public interface VueCategoryMapper 
{
    /**
     * 查询分类
     * 
     * @param id 分类ID
     * @return 分类
     */
    public VueCategory selectVueCategoryById(Long id);

    /**
     * 查询分类列表
     * 
     * @param vueCategory 分类
     * @return 分类集合
     */
    public List<VueCategory> selectVueCategoryList(VueCategory vueCategory);

    /**
     * 新增分类
     * 
     * @param vueCategory 分类
     * @return 结果
     */
    public int insertVueCategory(VueCategory vueCategory);

    /**
     * 修改分类
     * 
     * @param vueCategory 分类
     * @return 结果
     */
    public int updateVueCategory(VueCategory vueCategory);

    /**
     * 删除分类
     * 
     * @param id 分类ID
     * @return 结果
     */
    public int deleteVueCategoryById(Long id);

    /**
     * 批量删除分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueCategoryByIds(String[] ids);
}
