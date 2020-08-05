package com.crm.vue.mapper;

import com.crm.vue.domain.VueHomedata;

import java.util.List;

/**
 * 商品表Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueApiMapper
{
    /**
     * 查询商品表列表
     *
     * @param vueHomedata 商品表
     * @return 商品表集合
     */
    public List<VueHomedata> ListHomedata(VueHomedata vueHomedata);


}
