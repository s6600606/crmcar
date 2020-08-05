package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueDetailMapper;
import com.crm.vue.domain.VueDetail;
import com.crm.vue.service.IVueDetailService;
import com.crm.common.core.text.Convert;

/**
 * 商品详情Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueDetailServiceImpl implements IVueDetailService 
{
    @Autowired
    private VueDetailMapper vueDetailMapper;

    /**
     * 查询商品详情
     * 
     * @param iid 商品详情ID
     * @return 商品详情
     */
    @Override
    public VueDetail selectVueDetailById(Long iid)
    {
        return vueDetailMapper.selectVueDetailById(iid);
    }

    /**
     * 查询商品详情列表
     * 
     * @param vueDetail 商品详情
     * @return 商品详情
     */
    @Override
    public List<VueDetail> selectVueDetailList(VueDetail vueDetail)
    {
        return vueDetailMapper.selectVueDetailList(vueDetail);
    }

    /**
     * 新增商品详情
     * 
     * @param vueDetail 商品详情
     * @return 结果
     */
    @Override
    public int insertVueDetail(VueDetail vueDetail)
    {
        return vueDetailMapper.insertVueDetail(vueDetail);
    }

    /**
     * 修改商品详情
     * 
     * @param vueDetail 商品详情
     * @return 结果
     */
    @Override
    public int updateVueDetail(VueDetail vueDetail)
    {
        return vueDetailMapper.updateVueDetail(vueDetail);
    }

    /**
     * 删除商品详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueDetailByIds(String ids)
    {
        return vueDetailMapper.deleteVueDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品详情信息
     * 
     * @param iid 商品详情ID
     * @return 结果
     */
    @Override
    public int deleteVueDetailById(Long iid)
    {
        return vueDetailMapper.deleteVueDetailById(iid);
    }
}
