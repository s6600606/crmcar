package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueHomedataMapper;
import com.crm.vue.domain.VueHomedata;
import com.crm.vue.service.IVueHomedataService;
import com.crm.common.core.text.Convert;

/**
 * 商品表Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueHomedataServiceImpl implements IVueHomedataService 
{
    @Autowired
    private VueHomedataMapper vueHomedataMapper;

    /**
     * 查询商品表
     * 
     * @param id 商品表ID
     * @return 商品表
     */
    @Override
    public VueHomedata selectVueHomedataById(Long id)
    {
        return vueHomedataMapper.selectVueHomedataById(id);
    }

    /**
     * 查询商品表列表
     * 
     * @param vueHomedata 商品表
     * @return 商品表
     */
    @Override
    public List<VueHomedata> selectVueHomedataList(VueHomedata vueHomedata)
    {
        return vueHomedataMapper.selectVueHomedataList(vueHomedata);
    }

    /**
     * 新增商品表
     * 
     * @param vueHomedata 商品表
     * @return 结果
     */
    @Override
    public int insertVueHomedata(VueHomedata vueHomedata)
    {
        return vueHomedataMapper.insertVueHomedata(vueHomedata);
    }

    /**
     * 修改商品表
     * 
     * @param vueHomedata 商品表
     * @return 结果
     */
    @Override
    public int updateVueHomedata(VueHomedata vueHomedata)
    {
        return vueHomedataMapper.updateVueHomedata(vueHomedata);
    }

    /**
     * 删除商品表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueHomedataByIds(String ids)
    {
        return vueHomedataMapper.deleteVueHomedataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品表信息
     * 
     * @param id 商品表ID
     * @return 结果
     */
    @Override
    public int deleteVueHomedataById(Long id)
    {
        return vueHomedataMapper.deleteVueHomedataById(id);
    }
}
