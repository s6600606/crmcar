package com.crm.vue.service.impl;

import com.crm.common.core.text.Convert;
import com.crm.vue.domain.VueHomedata;
import com.crm.vue.mapper.VueApiMapper;
import com.crm.vue.mapper.VueHomedataMapper;
import com.crm.vue.service.IVueApiService;
import com.crm.vue.service.IVueHomedataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品表Service业务层处理
 * 
 * @author crm
 * @date 2020-07-31
 */
@Service
public class VueApiServiceImpl implements IVueApiService
{
    @Autowired
    private VueApiMapper vueApiMapper;

    /**
     * 查询商品表
     * 
     * @param id 商品表ID
     * @return 商品表
     */
    /**
     * 查询商品表列表
     * 
     * @param vueHomedata 商品表
     * @return 商品表
     */
    @Override
    public List<VueHomedata> ListHomedata(VueHomedata vueHomedata)
    {
        return vueApiMapper.ListHomedata(vueHomedata);
    }


}
