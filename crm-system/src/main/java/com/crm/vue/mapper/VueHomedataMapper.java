package com.crm.vue.mapper;

import com.crm.vue.domain.VueHomedata;

import java.util.List;

/**
 * 商品表Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueHomedataMapper 
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
     * 删除商品表
     * 
     * @param id 商品表ID
     * @return 结果
     */
    public int deleteVueHomedataById(Long id);

    /**
     * 批量删除商品表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueHomedataByIds(String[] ids);
}
