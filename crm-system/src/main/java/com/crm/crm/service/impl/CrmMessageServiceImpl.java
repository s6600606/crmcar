package com.crm.crm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmMessageMapper;
import com.crm.crm.domain.CrmMessage;
import com.crm.crm.service.ICrmMessageService;
import com.crm.common.core.text.Convert;

/**
 * 反馈消息Service业务层处理
 * 
 * @author crm
 * @date 2020-04-07
 */
@Service
public class CrmMessageServiceImpl implements ICrmMessageService 
{
    @Autowired
    private CrmMessageMapper crmMessageMapper;

    /**
     * 查询反馈消息
     * 
     * @param id 反馈消息ID
     * @return 反馈消息
     */
    @Override
    public CrmMessage selectCrmMessageById(Long id)
    {
        return crmMessageMapper.selectCrmMessageById(id);
    }

    /**
     * 查询反馈消息列表
     * 
     * @param crmMessage 反馈消息
     * @return 反馈消息
     */
    @Override
    public List<CrmMessage> selectCrmMessageList(CrmMessage crmMessage)
    {
        return crmMessageMapper.selectCrmMessageList(crmMessage);
    }

    public List<CrmMessage> selectCrmMessageByLoginName(String loginName){
        return crmMessageMapper.selectCrmMessageByLoginName(loginName);
    }

    /**
     * 新增反馈消息
     * 
     * @param crmMessage 反馈消息
     * @return 结果
     */
    @Override
    public int insertCrmMessage(CrmMessage crmMessage)
    {
        return crmMessageMapper.insertCrmMessage(crmMessage);
    }
    public int insertCrmMessageAll(CrmMessage crmMessage)
    {
        return crmMessageMapper.insertCrmMessageAll(crmMessage);
    }
    public int insertCrmMessageAuto(CrmMessage crmMessage){
        return crmMessageMapper.insertCrmMessageAuto(crmMessage);
    }
    /**
     * 修改反馈消息
     * 
     * @param crmMessage 反馈消息
     * @return 结果
     */
    @Override
    public int updateCrmMessage(CrmMessage crmMessage)
    {
        return crmMessageMapper.updateCrmMessage(crmMessage);
    }

    /**
     * 删除反馈消息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmMessageByIds(String ids)
    {
        return crmMessageMapper.deleteCrmMessageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反馈消息信息
     * 
     * @param id 反馈消息ID
     * @return 结果
     */
    @Override
    public int deleteCrmMessageById(Long id)
    {
        return crmMessageMapper.deleteCrmMessageById(id);
    }
}
