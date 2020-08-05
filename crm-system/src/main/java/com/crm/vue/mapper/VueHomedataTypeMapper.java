package com.crm.vue.mapper;

import com.crm.vue.domain.VueHomedataType;

import java.util.List;

/**
 * 商品类型Mapper接口
 * 
 * @author crm
 * @date 2020-07-31
 */
public interface VueHomedataTypeMapper 
{
    /**
     * 查询商品类型
     * 
     * @param id 商品类型ID
     * @return 商品类型
     */
    public VueHomedataType selectVueHomedataTypeById(Long id);

    /**
     * 查询商品类型列表
     * 
     * @param vueHomedataType 商品类型
     * @return 商品类型集合
     */
    public List<VueHomedataType> selectVueHomedataTypeList(VueHomedataType vueHomedataType);

    /**
     * 新增商品类型
     * 
     * @param vueHomedataType 商品类型
     * @return 结果
     */
    public int insertVueHomedataType(VueHomedataType vueHomedataType);

    /**
     * 修改商品类型
     * 
     * @param vueHomedataType 商品类型
     * @return 结果
     */
    public int updateVueHomedataType(VueHomedataType vueHomedataType);

    /**
     * 删除商品类型
     * 
     * @param id 商品类型ID
     * @return 结果
     */
    public int deleteVueHomedataTypeById(Long id);

    /**
     * 批量删除商品类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVueHomedataTypeByIds(String[] ids);
}
