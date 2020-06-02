package com.crm.crm.mapper;

import com.crm.crm.domain.CrmContacts;

import java.util.List;

/**
 * 联系人Mapper接口
 * 
 * @author crm
 * @date 2020-03-02
 */
public interface CrmContactsMapper 
{
    /**
     * 查询联系人
     * 
     * @param id 联系人ID
     * @return 联系人
     */
    public CrmContacts selectCrmContactsById(Long id);

    public List<CrmContacts> selectCrmContactsAll();
    /**
     * 查询联系人列表
     * 
     * @param crmContacts 联系人
     * @return 联系人集合
     */
    public List<CrmContacts> selectCrmContactsList(CrmContacts crmContacts);

    /**
     * 新增联系人
     * 
     * @param crmContacts 联系人
     * @return 结果
     */
    public int insertCrmContacts(CrmContacts crmContacts);

    /**
     * 修改联系人
     * 
     * @param crmContacts 联系人
     * @return 结果
     */
    public int updateCrmContacts(CrmContacts crmContacts);

    /**
     * 删除联系人
     * 
     * @param id 联系人ID
     * @return 结果
     */
    public int deleteCrmContactsById(Long id);

    /**
     * 批量删除联系人
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmContactsByIds(String[] ids);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public CrmContacts selectCrmByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     *
     * @param tel 手机号码
     * @return 用户对象信息
     */
    public CrmContacts selectCrmByTel(String tel);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    public CrmContacts selectCrmByEmail(String email);
}
