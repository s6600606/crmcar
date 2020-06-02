package com.crm.crm.service.impl;

import com.crm.common.core.text.Convert;
import com.crm.crm.domain.CrmOrderform;
import com.crm.crm.mapper.CrmOrderformMapper;
import com.crm.crm.service.ICrmOrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同Service业务层处理
 * 
 * @author crm
 * @date 2020-03-10
 */
@Service
public class CrmOrderformServiceImpl implements ICrmOrderformService
{
    @Autowired
    private CrmOrderformMapper crmOrderformMapper;


    @Override
    public List<CrmOrderform> selectCrmOrderformList(CrmOrderform crmOrderform){
        return crmOrderformMapper.selectCrmOrderformList(crmOrderform);
    }

    @Override
    public CrmOrderform selectCrmOrderformPrice(CrmOrderform crmOrderform){
        return crmOrderformMapper.selectCrmOrderformPrice(crmOrderform);
    }
}
