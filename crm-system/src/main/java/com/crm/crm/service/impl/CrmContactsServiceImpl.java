package com.crm.crm.service.impl;

import java.util.List;
import com.crm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmContactsMapper;
import com.crm.crm.domain.CrmContacts;
import com.crm.crm.service.ICrmContactsService;
import com.crm.common.core.text.Convert;

/**
 * 联系人Service业务层处理
 * 
 * @author crm
 * @date 2020-03-02
 */
@Service
public class CrmContactsServiceImpl implements ICrmContactsService 
{
    @Autowired
    private CrmContactsMapper crmContactsMapper;

    /**
     * 查询联系人
     * 
     * @param id 联系人ID
     * @return 联系人
     */
    @Override
    public CrmContacts selectCrmContactsById(Long id)
    {
        return crmContactsMapper.selectCrmContactsById(id);
    }
    public List<CrmContacts> selectCrmContactsAll(){
        return crmContactsMapper.selectCrmContactsAll();
    }
    /**
     * 查询联系人列表
     * 
     * @param crmContacts 联系人
     * @return 联系人
     */
    @Override
    public List<CrmContacts> selectCrmContactsList(CrmContacts crmContacts)
    {
        return crmContactsMapper.selectCrmContactsList(crmContacts);
    }

    /**
     * 新增联系人
     * 
     * @param crmContacts 联系人
     * @return 结果
     */
    @Override
    public int insertCrmContacts(CrmContacts crmContacts)
    {
        crmContacts.setCreateTime(DateUtils.getNowDate());
        return crmContactsMapper.insertCrmContacts(crmContacts);
    }

    /**
     * 修改联系人
     * 
     * @param crmContacts 联系人
     * @return 结果
     */
    @Override
    public int updateCrmContacts(CrmContacts crmContacts)
    {
        return crmContactsMapper.updateCrmContacts(crmContacts);
    }

    /**
     * 删除联系人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmContactsByIds(String ids)
    {
        return crmContactsMapper.deleteCrmContactsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除联系人信息
     * 
     * @param id 联系人ID
     * @return 结果
     */
    @Override
    public int deleteCrmContactsById(Long id)
    {
        return crmContactsMapper.deleteCrmContactsById(id);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public CrmContacts selectCrmByLoginName(String userName)
    {
        return crmContactsMapper.selectCrmByLoginName(userName);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param tel 手机号码
     * @return 用户对象信息
     */
    @Override
    public CrmContacts selectCrmByTel(String tel)
    {
        return crmContactsMapper.selectCrmByTel(tel);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public CrmContacts selectCrmByEmail(String email)
    {
        return crmContactsMapper.selectCrmByEmail(email);
    }
}
