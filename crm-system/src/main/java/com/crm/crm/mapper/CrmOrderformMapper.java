package com.crm.crm.mapper;

import com.crm.crm.domain.CrmOrderform;

import java.util.List;

public interface CrmOrderformMapper
{

    public List<CrmOrderform> selectCrmOrderformList(CrmOrderform crmOrderform);

    public CrmOrderform selectCrmOrderformPrice(CrmOrderform crmOrderform);
}
