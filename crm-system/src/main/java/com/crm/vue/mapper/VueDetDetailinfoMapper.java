package com.crm.vue.mapper;

import com.crm.vue.domain.VueDetDetailinfo;

import java.util.List;

/**
 * 商品信息Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueDetDetailinfoMapper 
{
    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    public VueDetDetailinfo selectVueDetDetailinfoById(Long id);

    /**
     * 查询商品信息列表
     * 
     * @param vueDetDetailinfo 商品信息
     * @return 商品信息集合
     */
    public List<VueDetDetailinfo> selectVueDetDetailinfoList(VueDetDetailinfo vueDetDetailinfo);

    /**
     * 新增商品信息
     * 
     * @param vueDetDetailinfo 商品信息
     * @return 结果
     */
    public int insertVueDetDetailinfo(VueDetDetailinfo vueDetDetailinfo);

    /**
     * 修改商品信息
     * 
     * @param vueDetDetailinfo 商品信息
     * @return 结果
     */
    public int updateVueDetDetailinfo(VueDetDetailinfo vueDetDetailinfo);

    /**
     * 删除商品信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteVueDetDetailinfoById(Long id);

    /**
     * 批量删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetDetailinfoByIds(String[] ids);
}
