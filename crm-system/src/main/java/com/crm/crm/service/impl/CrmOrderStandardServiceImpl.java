package com.crm.crm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmOrderStandardMapper;
import com.crm.crm.domain.CrmOrderStandard;
import com.crm.crm.service.ICrmOrderStandardService;
import com.crm.common.core.text.Convert;

/**
 * 业绩目标Service业务层处理
 * 
 * @author crm
 * @date 2020-05-05
 */
@Service
public class CrmOrderStandardServiceImpl implements ICrmOrderStandardService 
{
    @Autowired
    private CrmOrderStandardMapper crmOrderStandardMapper;

    /**
     * 查询业绩目标
     * 
     * @param id 业绩目标ID
     * @return 业绩目标
     */
    @Override
    public CrmOrderStandard selectCrmOrderStandardById(Long id)
    {
        return crmOrderStandardMapper.selectCrmOrderStandardById(id);
    }

    /**
     * 查询业绩目标列表
     * 
     * @param crmOrderStandard 业绩目标
     * @return 业绩目标
     */
    @Override
    public List<CrmOrderStandard> selectCrmOrderStandardList(CrmOrderStandard crmOrderStandard)
    {
        return crmOrderStandardMapper.selectCrmOrderStandardList(crmOrderStandard);
    }

    /**
     * 新增业绩目标
     * 
     * @param crmOrderStandard 业绩目标
     * @return 结果
     */
    @Override
    public int insertCrmOrderStandard(CrmOrderStandard crmOrderStandard)
    {
        return crmOrderStandardMapper.insertCrmOrderStandard(crmOrderStandard);
    }

    /**
     * 修改业绩目标
     * 
     * @param crmOrderStandard 业绩目标
     * @return 结果
     */
    @Override
    public int updateCrmOrderStandard(CrmOrderStandard crmOrderStandard)
    {
        return crmOrderStandardMapper.updateCrmOrderStandard(crmOrderStandard);
    }

    /**
     * 删除业绩目标对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmOrderStandardByIds(String ids)
    {
        return crmOrderStandardMapper.deleteCrmOrderStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除业绩目标信息
     * 
     * @param id 业绩目标ID
     * @return 结果
     */
    @Override
    public int deleteCrmOrderStandardById(Long id)
    {
        return crmOrderStandardMapper.deleteCrmOrderStandardById(id);
    }
}
