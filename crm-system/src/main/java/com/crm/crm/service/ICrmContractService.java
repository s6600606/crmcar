package com.crm.crm.service;

import com.crm.crm.domain.CrmContract;
import java.util.List;

/**
 * 合同Service接口
 * 
 * @author crm
 * @date 2020-03-10
 */
public interface ICrmContractService 
{
    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    public CrmContract selectCrmContractById(Long id);

    /**
     * 查询合同列表
     * 
     * @param crmContract 合同
     * @return 合同集合
     */
    public List<CrmContract> selectCrmContractList(CrmContract crmContract);

    /**
     * 新增合同
     * 
     * @param crmContract 合同
     * @return 结果
     */
    public int insertCrmContract(CrmContract crmContract);

    /**
     * 修改合同
     * 
     * @param crmContract 合同
     * @return 结果
     */
    public int updateCrmContract(CrmContract crmContract);

    /**
     * 批量删除合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmContractByIds(String ids);

    /**
     * 删除合同信息
     * 
     * @param id 合同ID
     * @return 结果
     */
    public int deleteCrmContractById(Long id);
}
