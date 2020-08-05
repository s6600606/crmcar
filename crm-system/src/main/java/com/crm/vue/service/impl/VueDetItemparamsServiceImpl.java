package com.crm.vue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.vue.mapper.VueDetItemparamsMapper;
import com.crm.vue.domain.VueDetItemparams;
import com.crm.vue.service.IVueDetItemparamsService;
import com.crm.common.core.text.Convert;

/**
 * 商品参数Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueDetItemparamsServiceImpl implements IVueDetItemparamsService 
{
    @Autowired
    private VueDetItemparamsMapper vueDetItemparamsMapper;

    /**
     * 查询商品参数
     * 
     * @param id 商品参数ID
     * @return 商品参数
     */
    @Override
    public VueDetItemparams selectVueDetItemparamsById(Long id)
    {
        return vueDetItemparamsMapper.selectVueDetItemparamsById(id);
    }

    @Override
    public VueDetItemparams ListVueDetItemparams(Long id){
        return vueDetItemparamsMapper.ListVueDetItemparams(id);
    }
    /**
     * 查询商品参数列表
     * 
     * @param vueDetItemparams 商品参数
     * @return 商品参数
     */
    @Override
    public List<VueDetItemparams> selectVueDetItemparamsList(VueDetItemparams vueDetItemparams)
    {
        return vueDetItemparamsMapper.selectVueDetItemparamsList(vueDetItemparams);
    }

    /**
     * 新增商品参数
     * 
     * @param vueDetItemparams 商品参数
     * @return 结果
     */
    @Override
    public int insertVueDetItemparams(VueDetItemparams vueDetItemparams)
    {
        return vueDetItemparamsMapper.insertVueDetItemparams(vueDetItemparams);
    }

    /**
     * 修改商品参数
     * 
     * @param vueDetItemparams 商品参数
     * @return 结果
     */
    @Override
    public int updateVueDetItemparams(VueDetItemparams vueDetItemparams)
    {
        return vueDetItemparamsMapper.updateVueDetItemparams(vueDetItemparams);
    }

    /**
     * 删除商品参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVueDetItemparamsByIds(String ids)
    {
        return vueDetItemparamsMapper.deleteVueDetItemparamsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品参数信息
     * 
     * @param id 商品参数ID
     * @return 结果
     */
    @Override
    public int deleteVueDetItemparamsById(Long id)
    {
        return vueDetItemparamsMapper.deleteVueDetItemparamsById(id);
    }
}
