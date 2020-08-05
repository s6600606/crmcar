package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueDetShopinfoMapper;
import com.crm.vue.domain.VueDetShopinfo;
import com.crm.vue.service.IVueDetShopinfoService;
import com.crm.common.core.text.Convert;

/**
 * 商家店铺Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueDetShopinfoServiceImpl implements IVueDetShopinfoService 
{
    @Autowired
    private VueDetShopinfoMapper vueDetShopinfoMapper;

    /**
     * 查询商家店铺
     * 
     * @param id 商家店铺ID
     * @return 商家店铺
     */
    @Override
    public VueDetShopinfo selectVueDetShopinfoById(Long id)
    {
        return vueDetShopinfoMapper.selectVueDetShopinfoById(id);
    }

    /**
     * 查询商家店铺列表
     * 
     * @param vueDetShopinfo 商家店铺
     * @return 商家店铺
     */
    @Override
    public List<VueDetShopinfo> selectVueDetShopinfoList(VueDetShopinfo vueDetShopinfo)
    {
        return vueDetShopinfoMapper.selectVueDetShopinfoList(vueDetShopinfo);
    }

    /**
     * 新增商家店铺
     * 
     * @param vueDetShopinfo 商家店铺
     * @return 结果
     */
    @Override
    public int insertVueDetShopinfo(VueDetShopinfo vueDetShopinfo)
    {
        return vueDetShopinfoMapper.insertVueDetShopinfo(vueDetShopinfo);
    }

    /**
     * 修改商家店铺
     * 
     * @param vueDetShopinfo 商家店铺
     * @return 结果
     */
    @Override
    public int updateVueDetShopinfo(VueDetShopinfo vueDetShopinfo)
    {
        return vueDetShopinfoMapper.updateVueDetShopinfo(vueDetShopinfo);
    }

    /**
     * 删除商家店铺对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueDetShopinfoByIds(String ids)
    {
        return vueDetShopinfoMapper.deleteVueDetShopinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商家店铺信息
     * 
     * @param id 商家店铺ID
     * @return 结果
     */
    @Override
    public int deleteVueDetShopinfoById(Long id)
    {
        return vueDetShopinfoMapper.deleteVueDetShopinfoById(id);
    }
}
