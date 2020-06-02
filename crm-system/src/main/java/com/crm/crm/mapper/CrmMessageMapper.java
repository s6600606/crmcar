package com.crm.crm.mapper;

import com.crm.crm.domain.CrmMessage;
import java.util.List;

/**
 * 反馈消息Mapper接口
 * 
 * @author crm
 * @date 2020-04-07
 */
public interface CrmMessageMapper 
{
    /**
     * 查询反馈消息
     * 
     * @param id 反馈消息ID
     * @return 反馈消息
     */
    public CrmMessage selectCrmMessageById(Long id);

    /**
     * 查询反馈消息列表
     * 
     * @param crmMessage 反馈消息
     * @return 反馈消息集合
     */
    public List<CrmMessage> selectCrmMessageList(CrmMessage crmMessage);

    public List<CrmMessage> selectCrmMessageByLoginName(String loginName);

    /**
     * 新增反馈消息
     * 
     * @param crmMessage 反馈消息
     * @return 结果
     */
    public int insertCrmMessage(CrmMessage crmMessage);
    public int insertCrmMessageAll(CrmMessage crmMessage);
    public int insertCrmMessageAuto(CrmMessage crmMessage);

    /**
     * 修改反馈消息
     * 
     * @param crmMessage 反馈消息
     * @return 结果
     */
    public int updateCrmMessage(CrmMessage crmMessage);

    /**
     * 删除反馈消息
     * 
     * @param id 反馈消息ID
     * @return 结果
     */
    public int deleteCrmMessageById(Long id);

    /**
     * 批量删除反馈消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmMessageByIds(String[] ids);
}
