package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueHomedataTypeMapper;
import com.crm.vue.domain.VueHomedataType;
import com.crm.vue.service.IVueHomedataTypeService;
import com.crm.common.core.text.Convert;

/**
 * 商品类型Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueHomedataTypeServiceImpl implements IVueHomedataTypeService 
{
    @Autowired
    private VueHomedataTypeMapper vueHomedataTypeMapper;

    /**
     * 查询商品类型
     * 
     * @param id 商品类型ID
     * @return 商品类型
     */
    @Override
    public VueHomedataType selectVueHomedataTypeById(Long id)
    {
        return vueHomedataTypeMapper.selectVueHomedataTypeById(id);
    }

    /**
     * 查询商品类型列表
     * 
     * @param vueHomedataType 商品类型
     * @return 商品类型
     */
    @Override
    public List<VueHomedataType> selectVueHomedataTypeList(VueHomedataType vueHomedataType)
    {
        return vueHomedataTypeMapper.selectVueHomedataTypeList(vueHomedataType);
    }

    /**
     * 新增商品类型
     * 
     * @param vueHomedataType 商品类型
     * @return 结果
     */
    @Override
    public int insertVueHomedataType(VueHomedataType vueHomedataType)
    {
        return vueHomedataTypeMapper.insertVueHomedataType(vueHomedataType);
    }

    /**
     * 修改商品类型
     * 
     * @param vueHomedataType 商品类型
     * @return 结果
     */
    @Override
    public int updateVueHomedataType(VueHomedataType vueHomedataType)
    {
        return vueHomedataTypeMapper.updateVueHomedataType(vueHomedataType);
    }

    /**
     * 删除商品类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueHomedataTypeByIds(String ids)
    {
        return vueHomedataTypeMapper.deleteVueHomedataTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品类型信息
     * 
     * @param id 商品类型ID
     * @return 结果
     */
    @Override
    public int deleteVueHomedataTypeById(Long id)
    {
        return vueHomedataTypeMapper.deleteVueHomedataTypeById(id);
    }
}
