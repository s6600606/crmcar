package com.crm.crm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmAppointMapper;
import com.crm.crm.domain.CrmAppoint;
import com.crm.crm.service.ICrmAppointService;
import com.crm.common.core.text.Convert;

/**
 * 预约信息Service业务层处理
 * 
 * @author crm
 * @date 2020-04-07
 */
@Service
public class CrmAppointServiceImpl implements ICrmAppointService 
{
    @Autowired
    private CrmAppointMapper crmAppointMapper;

    /**
     * 查询预约信息
     * 
     * @param id 预约信息ID
     * @return 预约信息
     */
    @Override
    public CrmAppoint selectCrmAppointById(Long id)
    {
        return crmAppointMapper.selectCrmAppointById(id);
    }

    /**
     * 查询预约信息列表
     * 
     * @param crmAppoint 预约信息
     * @return 预约信息
     */
    @Override
    public List<CrmAppoint> selectCrmAppointList(CrmAppoint crmAppoint)
    {
        return crmAppointMapper.selectCrmAppointList(crmAppoint);
    }
    @Override
    public List<CrmAppoint> selectCrmAppointByLoginName(String loginName)
    {
        return crmAppointMapper.selectCrmAppointByLoginName(loginName);
    }

    /**
     * 新增预约信息
     * 
     * @param crmAppoint 预约信息
     * @return 结果
     */
    @Override
    public int insertCrmAppoint(CrmAppoint crmAppoint)
    {
        return crmAppointMapper.insertCrmAppoint(crmAppoint);
    }

    /**
     * 修改预约信息
     * 
     * @param crmAppoint 预约信息
     * @return 结果
     */
    @Override
    public int updateCrmAppoint(CrmAppoint crmAppoint)
    {
        return crmAppointMapper.updateCrmAppoint(crmAppoint);
    }

    /**
     * 删除预约信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmAppointByIds(String ids)
    {
        return crmAppointMapper.deleteCrmAppointByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除预约信息信息
     * 
     * @param id 预约信息ID
     * @return 结果
     */
    @Override
    public int deleteCrmAppointById(Long id)
    {
        return crmAppointMapper.deleteCrmAppointById(id);
    }
}
