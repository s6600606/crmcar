package com.crm.vue.service;

import java.util.List;
import com.crm.vue.domain.VueDetIteminfo;

/**
 * 商品信息Service接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface IVueDetIteminfoService 
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
     * 批量删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueDetIteminfoByIds(String ids);

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteVueDetIteminfoById(Long id);
}
