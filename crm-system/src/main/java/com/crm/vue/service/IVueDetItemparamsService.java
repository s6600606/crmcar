package com.crm.vue.service;

import java.util.List;
import com.crm.vue.domain.VueDetItemparams;

/**
 * 商品参数Service接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface IVueDetItemparamsService 
{
    /**
     * 查询商品参数
     * 
     * @param id 商品参数ID
     * @return 商品参数
     */
    public VueDetItemparams selectVueDetItemparamsById(Long id);

    public VueDetItemparams ListVueDetItemparams(Long id);
    /**
     * 查询商品参数列表
     * 
     * @param vueDetItemparams 商品参数
     * @return 商品参数集合
     */
    public List<VueDetItemparams> selectVueDetItemparamsList(VueDetItemparams vueDetItemparams);

    /**
     * 新增商品参数
     * 
     * @param vueDetItemparams 商品参数
     * @return 结果
     */
    public int insertVueDetItemparams(VueDetItemparams vueDetItemparams);

    /**
     * 修改商品参数
     * 
     * @param vueDetItemparams 商品参数
     * @return 结果
     */
    public int updateVueDetItemparams(VueDetItemparams vueDetItemparams);

    /**
     * 批量删除商品参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetItemparamsByIds(String ids);

    /**
     * 删除商品参数信息
     * 
     * @param id 商品参数ID
     * @return 结果
     */
    public int deleteVueDetItemparamsById(Long id);
}
