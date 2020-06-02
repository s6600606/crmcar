package com.crm.crm.service;

import com.crm.crm.domain.CrmAppoint;
import java.util.List;

/**
 * 预约信息Service接口
 * 
 * @author crm
 * @date 2020-04-07
 */
public interface ICrmAppointService 
{
    /**
     * 查询预约信息
     * 
     * @param id 预约信息ID
     * @return 预约信息
     */
    public CrmAppoint selectCrmAppointById(Long id);

    /**
     * 查询预约信息列表
     * 
     * @param crmAppoint 预约信息
     * @return 预约信息集合
     */
    public List<CrmAppoint> selectCrmAppointList(CrmAppoint crmAppoint);
    public List<CrmAppoint> selectCrmAppointByLoginName(String loginName);

    /**
     * 新增预约信息
     * 
     * @param crmAppoint 预约信息
     * @return 结果
     */
    public int insertCrmAppoint(CrmAppoint crmAppoint);

    /**
     * 修改预约信息
     * 
     * @param crmAppoint 预约信息
     * @return 结果
     */
    public int updateCrmAppoint(CrmAppoint crmAppoint);

    /**
     * 批量删除预约信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmAppointByIds(String ids);

    /**
     * 删除预约信息信息
     * 
     * @param id 预约信息ID
     * @return 结果
     */
    public int deleteCrmAppointById(Long id);
}
