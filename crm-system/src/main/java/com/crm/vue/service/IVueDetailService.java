package com.crm.vue.service;

import com.crm.vue.domain.VueDetail;

import java.util.List;

/**
 * 商品详情Service接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface IVueDetailService
{
    /**
     * 查询商品详情
     * 
     * @param iid 商品详情ID
     * @return 商品详情
     */
    public VueDetail selectVueDetailById(Long iid);

    /**
     * 查询商品详情列表
     * 
     * @param vueDetail 商品详情
     * @return 商品详情集合
     */
    public List<VueDetail> selectVueDetailList(VueDetail vueDetail);

    /**
     * 新增商品详情
     * 
     * @param vueDetail 商品详情
     * @return 结果
     */
    public int insertVueDetail(VueDetail vueDetail);

    /**
     * 修改商品详情
     * 
     * @param vueDetail 商品详情
     * @return 结果
     */
    public int updateVueDetail(VueDetail vueDetail);

    /**
     * 批量删除商品详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetailByIds(String ids);

    /**
     * 删除商品详情信息
     * 
     * @param iid 商品详情ID
     * @return 结果
     */
    public int deleteVueDetailById(Long iid);
}
