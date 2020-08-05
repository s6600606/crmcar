package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueDetRateMapper;
import com.crm.vue.domain.VueDetRate;
import com.crm.vue.service.IVueDetRateService;
import com.crm.common.core.text.Convert;

/**
 * 评论Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueDetRateServiceImpl implements IVueDetRateService 
{
    @Autowired
    private VueDetRateMapper vueDetRateMapper;

    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    @Override
    public VueDetRate selectVueDetRateById(Long id)
    {
        return vueDetRateMapper.selectVueDetRateById(id);
    }

    /**
     * 查询评论列表
     * 
     * @param vueDetRate 评论
     * @return 评论
     */
    @Override
    public List<VueDetRate> selectVueDetRateList(VueDetRate vueDetRate)
    {
        return vueDetRateMapper.selectVueDetRateList(vueDetRate);
    }

    /**
     * 新增评论
     * 
     * @param vueDetRate 评论
     * @return 结果
     */
    @Override
    public int insertVueDetRate(VueDetRate vueDetRate)
    {
        return vueDetRateMapper.insertVueDetRate(vueDetRate);
    }

    /**
     * 修改评论
     * 
     * @param vueDetRate 评论
     * @return 结果
     */
    @Override
    public int updateVueDetRate(VueDetRate vueDetRate)
    {
        return vueDetRateMapper.updateVueDetRate(vueDetRate);
    }

    /**
     * 删除评论对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueDetRateByIds(String ids)
    {
        return vueDetRateMapper.deleteVueDetRateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论信息
     * 
     * @param id 评论ID
     * @return 结果
     */
    @Override
    public int deleteVueDetRateById(Long id)
    {
        return vueDetRateMapper.deleteVueDetRateById(id);
    }
}
