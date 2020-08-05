package com.crm.vue.service;

import com.crm.vue.domain.VueHomedata;

import java.util.List;

/**
 * 商品表Service接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface IVueApiService
{
    /**
     * 查询商品表
     * 
     * @param id 商品表ID
     * @return 商品表
     */

    /**
     * 查询商品表列表
     * 
     * @param vueHomedata 商品表
     * @return 商品表集合
     */
    public List<VueHomedata> ListHomedata(VueHomedata vueHomedata);


}
