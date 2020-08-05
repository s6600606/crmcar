package com.crm.vue.mapper;

import com.crm.vue.domain.VueDetIteminfo;

import java.util.List;

/**
 * 商品信息Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueDetIteminfoMapper 
{
    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    public VueDetIteminfo selectVueDetIteminfoById(Long id);

    /**
     * 查询商品信息列表
     * 
     * @param vueDetIteminfo 商品信息
     * @return 商品信息集合
     */
    public List<VueDetIteminfo> selectVueDetIteminfoList(VueDetIteminfo vueDetIteminfo);

    /**
     * 新增商品信息
     * 
     * @param vueDetIteminfo 商品信息
     * @return 结果
     */
    public int insertVueDetIteminfo(VueDetIteminfo vueDetIteminfo);

    /**
     * 修改商品信息
     * 
     * @param vueDetIteminfo 商品信息
     * @return 结果
     */
    public int updateVueDetIteminfo(VueDetIteminfo vueDetIteminfo);

    /**
     * 删除商品信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteVueDetIteminfoById(Long id);

    /**
     * 批量删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetIteminfoByIds(String[] ids);
}
