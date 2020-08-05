package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueDetDetailinfoMapper;
import com.crm.vue.domain.VueDetDetailinfo;
import com.crm.vue.service.IVueDetDetailinfoService;
import com.crm.common.core.text.Convert;

/**
 * 商品信息Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueDetDetailinfoServiceImpl implements IVueDetDetailinfoService 
{
    @Autowired
    private VueDetDetailinfoMapper vueDetDetailinfoMapper;

    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    @Override
    public VueDetDetailinfo selectVueDetDetailinfoById(Long id)
    {
        return vueDetDetailinfoMapper.selectVueDetDetailinfoById(id);
    }

    /**
     * 查询商品信息列表
     * 
     * @param vueDetDetailinfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<VueDetDetailinfo> selectVueDetDetailinfoList(VueDetDetailinfo vueDetDetailinfo)
    {
        return vueDetDetailinfoMapper.selectVueDetDetailinfoList(vueDetDetailinfo);
    }

    /**
     * 新增商品信息
     * 
     * @param vueDetDetailinfo 商品信息
     * @return 结果
     */
    @Override
    public int insertVueDetDetailinfo(VueDetDetailinfo vueDetDetailinfo)
    {
        return vueDetDetailinfoMapper.insertVueDetDetailinfo(vueDetDetailinfo);
    }

    /**
     * 修改商品信息
     * 
     * @param vueDetDetailinfo 商品信息
     * @return 结果
     */
    @Override
    public int updateVueDetDetailinfo(VueDetDetailinfo vueDetDetailinfo)
    {
        return vueDetDetailinfoMapper.updateVueDetDetailinfo(vueDetDetailinfo);
    }

    /**
     * 删除商品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueDetDetailinfoByIds(String ids)
    {
        return vueDetDetailinfoMapper.deleteVueDetDetailinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteVueDetDetailinfoById(Long id)
    {
        return vueDetDetailinfoMapper.deleteVueDetDetailinfoById(id);
    }
}
