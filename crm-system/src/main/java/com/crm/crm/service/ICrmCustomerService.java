package com.crm.crm.service;

import com.crm.crm.domain.CrmCustomer;

import java.util.List;

/**
 * 联系人Service接口
 * 
 * @author crm
 * @date 2020-03-02
 */
public interface ICrmCustomerService 
{
    /**
     * 查询联系人
     * 
     * @param id 联系人ID
     * @return 联系人
     */
    public CrmCustomer selectCrmCustomerById(Long id);

    /**
     * 查询联系人列表
     * 
     * @param CrmCustomer 联系人
     * @return 联系人集合
     */
    public List<CrmCustomer> selectCrmCustomerList(CrmCustomer CrmCustomer);

    /**
     * 新增联系人
     * 
     * @param CrmCustomer 联系人
     * @return 结果
     */
    public int insertCrmCustomer(CrmCustomer CrmCustomer);

    /**
     * 修改联系人
     * 
     * @param CrmCustomer 联系人
     * @return 结果
     */
    public int updateCrmCustomer(CrmCustomer CrmCustomer);

    /**
     * 批量删除联系人
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmCustomerByIds(String ids);

    /**
     * 删除联系人信息
     * 
     * @param id 联系人ID
     * @return 结果
     */
    public int deleteCrmCustomerById(Long id);


}
