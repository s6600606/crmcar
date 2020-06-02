package com.crm.crm.service;

import com.crm.crm.domain.CrmOrderform;

import java.util.List;

public interface ICrmOrderformService
{
    public List<CrmOrderform> selectCrmOrderformList(CrmOrderform crmOrderform);

    public CrmOrderform selectCrmOrderformPrice(CrmOrderform crmOrderform);
}
