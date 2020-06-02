package com.crm.crm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmContractMapper;
import com.crm.crm.domain.CrmContract;
import com.crm.crm.service.ICrmContractService;
import com.crm.common.core.text.Convert;

/**
 * 合同Service业务层处理
 * 
 * @author crm
 * @date 2020-03-10
 */
@Service
public class CrmContractServiceImpl implements ICrmContractService 
{
    @Autowired
    private CrmContractMapper crmContractMapper;

    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    @Override
    public CrmContract selectCrmContractById(Long id)
    {
        return crmContractMapper.selectCrmContractById(id);
    }

    /**
     * 查询合同列表
     * 
     * @param crmContract 合同
     * @return 合同
     */
    @Override
    public List<CrmContract> selectCrmContractList(CrmContract crmContract)
    {
        return crmContractMapper.selectCrmContractList(crmContract);
    }

    /**
     * 新增合同
     * 
     * @param crmContract 合同
     * @return 结果
     */
    @Override
    public int insertCrmContract(CrmContract crmContract)
    {
        return crmContractMapper.insertCrmContract(crmContract);
    }

    /**
     * 修改合同
     * 
     * @param crmContract 合同
     * @return 结果
     */
    @Override
    public int updateCrmContract(CrmContract crmContract)
    {
        return crmContractMapper.updateCrmContract(crmContract);
    }

    /**
     * 删除合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmContractByIds(String ids)
    {
        return crmContractMapper.deleteCrmContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同信息
     * 
     * @param id 合同ID
     * @return 结果
     */
    @Override
    public int deleteCrmContractById(Long id)
    {
        return crmContractMapper.deleteCrmContractById(id);
    }
}
