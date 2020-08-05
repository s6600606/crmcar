package com.crm.vue.mapper;

import com.crm.vue.domain.VueDetRate;

import java.util.List;

/**
 * 评论Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueDetRateMapper 
{
    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    public VueDetRate selectVueDetRateById(Long id);

    /**
     * 查询评论列表
     * 
     * @param vueDetRate 评论
     * @return 评论集合
     */
    public List<VueDetRate> selectVueDetRateList(VueDetRate vueDetRate);

    /**
     * 新增评论
     * 
     * @param vueDetRate 评论
     * @return 结果
     */
    public int insertVueDetRate(VueDetRate vueDetRate);

    /**
     * 修改评论
     * 
     * @param vueDetRate 评论
     * @return 结果
     */
    public int updateVueDetRate(VueDetRate vueDetRate);

    /**
     * 删除评论
     * 
     * @param id 评论ID
     * @return 结果
     */
    public int deleteVueDetRateById(Long id);

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetRateByIds(String[] ids);
}
