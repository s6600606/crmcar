package com.crm.crm.service;

import com.crm.crm.domain.CrmMsgFeedback;
import java.util.List;

/**
 * 反馈建议Service接口
 * 
 * @author crm
 * @date 2020-04-09
 */
public interface ICrmMsgFeedbackService 
{
    /**
     * 查询反馈建议
     * 
     * @param id 反馈建议ID
     * @return 反馈建议
     */
    public CrmMsgFeedback selectCrmMsgFeedbackById(Long id);

    /**
     * 查询反馈建议列表
     * 
     * @param crmMsgFeedback 反馈建议
     * @return 反馈建议集合
     */
    public List<CrmMsgFeedback> selectCrmMsgFeedbackList(CrmMsgFeedback crmMsgFeedback);

    /**
     * 新增反馈建议
     * 
     * @param crmMsgFeedback 反馈建议
     * @return 结果
     */
    public int insertCrmMsgFeedback(CrmMsgFeedback crmMsgFeedback);

    /**
     * 修改反馈建议
     * 
     * @param crmMsgFeedback 反馈建议
     * @return 结果
     */
    public int updateCrmMsgFeedback(CrmMsgFeedback crmMsgFeedback);

    /**
     * 批量删除反馈建议
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmMsgFeedbackByIds(String ids);

    /**
     * 删除反馈建议信息
     * 
     * @param id 反馈建议ID
     * @return 结果
     */
    public int deleteCrmMsgFeedbackById(Long id);
}
