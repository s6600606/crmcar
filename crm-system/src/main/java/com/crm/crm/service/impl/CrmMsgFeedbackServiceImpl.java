package com.crm.crm.service.impl;

import java.util.List;
import com.crm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmMsgFeedbackMapper;
import com.crm.crm.domain.CrmMsgFeedback;
import com.crm.crm.service.ICrmMsgFeedbackService;
import com.crm.common.core.text.Convert;

/**
 * 反馈建议Service业务层处理
 * 
 * @author crm
 * @date 2020-04-09
 */
@Service
public class CrmMsgFeedbackServiceImpl implements ICrmMsgFeedbackService 
{
    @Autowired
    private CrmMsgFeedbackMapper crmMsgFeedbackMapper;

    /**
     * 查询反馈建议
     * 
     * @param id 反馈建议ID
     * @return 反馈建议
     */
    @Override
    public CrmMsgFeedback selectCrmMsgFeedbackById(Long id)
    {
        return crmMsgFeedbackMapper.selectCrmMsgFeedbackById(id);
    }

    /**
     * 查询反馈建议列表
     * 
     * @param crmMsgFeedback 反馈建议
     * @return 反馈建议
     */
    @Override
    public List<CrmMsgFeedback> selectCrmMsgFeedbackList(CrmMsgFeedback crmMsgFeedback)
    {
        return crmMsgFeedbackMapper.selectCrmMsgFeedbackList(crmMsgFeedback);
    }

    /**
     * 新增反馈建议
     * 
     * @param crmMsgFeedback 反馈建议
     * @return 结果
     */
    @Override
    public int insertCrmMsgFeedback(CrmMsgFeedback crmMsgFeedback)
    {
        crmMsgFeedback.setCreateTime(DateUtils.getNowDate());
        return crmMsgFeedbackMapper.insertCrmMsgFeedback(crmMsgFeedback);
    }

    /**
     * 修改反馈建议
     * 
     * @param crmMsgFeedback 反馈建议
     * @return 结果
     */
    @Override
    public int updateCrmMsgFeedback(CrmMsgFeedback crmMsgFeedback)
    {
        return crmMsgFeedbackMapper.updateCrmMsgFeedback(crmMsgFeedback);
    }

    /**
     * 删除反馈建议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmMsgFeedbackByIds(String ids)
    {
        return crmMsgFeedbackMapper.deleteCrmMsgFeedbackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反馈建议信息
     * 
     * @param id 反馈建议ID
     * @return 结果
     */
    @Override
    public int deleteCrmMsgFeedbackById(Long id)
    {
        return crmMsgFeedbackMapper.deleteCrmMsgFeedbackById(id);
    }
}
