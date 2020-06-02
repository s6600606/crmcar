package com.crm.crm.service.impl;

import com.crm.common.core.text.Convert;
import com.crm.common.utils.DateUtils;
import com.crm.crm.domain.CrmCustomer;
import com.crm.crm.mapper.CrmCustomerMapper;
import com.crm.crm.service.ICrmCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系人Service业务层处理
 * 
 * @author crm
 * @date 2020-03-02
 */
@Service
public class CrmCustomerServiceImpl implements ICrmCustomerService 
{
    @Autowired
    private CrmCustomerMapper CrmCustomerMapper;

    /**
     * 查询联系人
     * 
     * @param id 联系人ID
     * @return 联系人
     */
    @Override
    public CrmCustomer selectCrmCustomerById(Long id)
    {
        return CrmCustomerMapper.selectCrmCustomerById(id);
    }

    /**
     * 查询联系人列表
     * 
     * @param CrmCustomer 联系人
     * @return 联系人
     */
    @Override
    public List<CrmCustomer> selectCrmCustomerList(CrmCustomer CrmCustomer)
    {
        return CrmCustomerMapper.selectCrmCustomerList(CrmCustomer);
    }

    /**
     * 新增联系人
     * 
     * @param CrmCustomer 联系人
     * @return 结果
     */
    @Override
    public int insertCrmCustomer(CrmCustomer CrmCustomer)
    {
        CrmCustomer.setCreateTime(DateUtils.getNowDate());
        return CrmCustomerMapper.insertCrmCustomer(CrmCustomer);
    }

    /**
     * 修改联系人
     * 
     * @param CrmCustomer 联系人
     * @return 结果
     */
    @Override
    public int updateCrmCustomer(CrmCustomer CrmCustomer)
    {
        return CrmCustomerMapper.updateCrmCustomer(CrmCustomer);
    }

    /**
     * 删除联系人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmCustomerByIds(String ids)
    {
        return CrmCustomerMapper.deleteCrmCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除联系人信息
     * 
     * @param id 联系人ID
     * @return 结果
     */
    @Override
    public int deleteCrmCustomerById(Long id)
    {
        return CrmCustomerMapper.deleteCrmCustomerById(id);
    }


}
