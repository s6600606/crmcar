package com.crm.vue.mapper;

import com.crm.vue.domain.VueDetShopinfo;

import java.util.List;

/**
 * 商家店铺Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueDetShopinfoMapper 
{
    /**
     * 查询商家店铺
     * 
     * @param id 商家店铺ID
     * @return 商家店铺
     */
    public VueDetShopinfo selectVueDetShopinfoById(Long id);

    /**
     * 查询商家店铺列表
     * 
     * @param vueDetShopinfo 商家店铺
     * @return 商家店铺集合
     */
    public List<VueDetShopinfo> selectVueDetShopinfoList(VueDetShopinfo vueDetShopinfo);

    /**
     * 新增商家店铺
     * 
     * @param vueDetShopinfo 商家店铺
     * @return 结果
     */
    public int insertVueDetShopinfo(VueDetShopinfo vueDetShopinfo);

    /**
     * 修改商家店铺
     * 
     * @param vueDetShopinfo 商家店铺
     * @return 结果
     */
    public int updateVueDetShopinfo(VueDetShopinfo vueDetShopinfo);

    /**
     * 删除商家店铺
     * 
     * @param id 商家店铺ID
     * @return 结果
     */
    public int deleteVueDetShopinfoById(Long id);

    /**
     * 批量删除商家店铺
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetShopinfoByIds(String[] ids);
}
