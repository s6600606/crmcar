package com.crm.vue.service;

import java.util.List;
import com.crm.vue.domain.VueCatSubcategory;

/**
 * 具体分类Service接口
 * 
 * @author crm
 * @date 2020-08-04
 */
public interface IVueCatSubcategoryService 
{
    /**
     * 查询具体分类
     * 
     * @param id 具体分类ID
     * @return 具体分类
     */
    public VueCatSubcategory selectVueCatSubcategoryById(Long id);

    /**
     * 查询具体分类列表
     * 
     * @param vueCatSubcategory 具体分类
     * @return 具体分类集合
     */
    public List<VueCatSubcategory> selectVueCatSubcategoryList(VueCatSubcategory vueCatSubcategory);

    /**
     * 新增具体分类
     * 
     * @param vueCatSubcategory 具体分类
     * @return 结果
     */
    public int insertVueCatSubcategory(VueCatSubcategory vueCatSubcategory);

    /**
     * 修改具体分类
     * 
     * @param vueCatSubcategory 具体分类
     * @return 结果
     */
    public int updateVueCatSubcategory(VueCatSubcategory vueCatSubcategory);

    /**
     * 批量删除具体分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueCatSubcategoryByIds(String ids);

    /**
     * 删除具体分类信息
     * 
     * @param id 具体分类ID
     * @return 结果
     */
    public int deleteVueCatSubcategoryById(Long id);
}
