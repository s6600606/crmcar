package com.crm.vue.service;

import java.util.List;
import com.crm.vue.domain.VueHomedata;

/**
 * 商品表Service接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface IVueHomedataService 
{
    /**
     * 查询商品表
     * 
     * @param id 商品表ID
     * @return 商品表
     */
    public VueHomedata selectVueHomedataById(Long id);

    /**
     * 查询商品表列表
     * 
     * @param vueHomedata 商品表
     * @return 商品表集合
     */
    public List<VueHomedata> selectVueHomedataList(VueHomedata vueHomedata);

    /**
     * 新增商品表
     * 
     * @param vueHomedata 商品表
     * @return 结果
     */
    public int insertVueHomedata(VueHomedata vueHomedata);

    /**
     * 修改商品表
     * 
     * @param vueHomedata 商品表
     * @return 结果
     */
    public int updateVueHomedata(VueHomedata vueHomedata);

    /**
     * 批量删除商品表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueHomedataByIds(String ids);

    /**
     * 删除商品表信息
     * 
     * @param id 商品表ID
     * @return 结果
     */
    public int deleteVueHomedataById(Long id);
}
