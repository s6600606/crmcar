package com.crm.vue.mapper;

import com.crm.vue.domain.VueDetail;

import java.util.List;

/**
 * 商品详情Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueDetailMapper 
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
     * 删除商品详情
     * 
     * @param iid 商品详情ID
     * @return 结果
     */
    public int deleteVueDetailById(Long iid);

    /**
     * 批量删除商品详情
     * 
     * @param iids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetailByIds(String[] iids);
}
