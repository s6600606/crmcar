package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueDetIteminfoMapper;
import com.crm.vue.domain.VueDetIteminfo;
import com.crm.vue.service.IVueDetIteminfoService;
import com.crm.common.core.text.Convert;

/**
 * 商品信息Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueDetIteminfoServiceImpl implements IVueDetIteminfoService 
{
    @Autowired
    private VueDetIteminfoMapper vueDetIteminfoMapper;

    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    @Override
    public VueDetIteminfo selectVueDetIteminfoById(Long id)
    {
        return vueDetIteminfoMapper.selectVueDetIteminfoById(id);
    }

    /**
     * 查询商品信息列表
     * 
     * @param vueDetIteminfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<VueDetIteminfo> selectVueDetIteminfoList(VueDetIteminfo vueDetIteminfo)
    {
        return vueDetIteminfoMapper.selectVueDetIteminfoList(vueDetIteminfo);
    }

    /**
     * 新增商品信息
     * 
     * @param vueDetIteminfo 商品信息
     * @return 结果
     */
    @Override
    public int insertVueDetIteminfo(VueDetIteminfo vueDetIteminfo)
    {
        return vueDetIteminfoMapper.insertVueDetIteminfo(vueDetIteminfo);
    }

    /**
     * 修改商品信息
     * 
     * @param vueDetIteminfo 商品信息
     * @return 结果
     */
    @Override
    public int updateVueDetIteminfo(VueDetIteminfo vueDetIteminfo)
    {
        return vueDetIteminfoMapper.updateVueDetIteminfo(vueDetIteminfo);
    }

    /**
     * 删除商品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueDetIteminfoByIds(String ids)
    {
        return vueDetIteminfoMapper.deleteVueDetIteminfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteVueDetIteminfoById(Long id)
    {
        return vueDetIteminfoMapper.deleteVueDetIteminfoById(id);
    }
}
