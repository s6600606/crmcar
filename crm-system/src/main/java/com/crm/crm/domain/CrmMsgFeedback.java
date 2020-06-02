package com.crm.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;

/**
 * 反馈建议对象 crm_msg_feedback
 * 
 * @author crm
 * @date 2020-04-09
 */
public class CrmMsgFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 反馈ID */
    private Long id;

    /** 反馈标题 */
    @Excel(name = "反馈标题")
    private String title;

    /** 反馈主体 */
    @Excel(name = "反馈主体")
    private String msg;

    /** 收信人用户名 */
    @Excel(name = "收信人用户名")
    private String uName;
    /** 收信人电话 */
    @Excel(name = "收信人电话")
    private String phonenumber;
    /** 反馈人用户名 */
    @Excel(name = "反馈人用户名")
    private String ctName;
    /** 反馈人电话 */
    @Excel(name = "反馈人电话")
    private String tel;
    /** 反馈人性别 */
    @Excel(name = "反馈人性别")
    private String sex;


    /** 反馈人 */
    @Excel(name = "反馈人")
    private Long addresserId;

    /** 收信人 */
    @Excel(name = "收信人")
    private Long addresseeId;

    /** 是否已读 */
    @Excel(name = "是否已读")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setMsg(String msg) 
    {
        this.msg = msg;
    }

    public String getMsg() 
    {
        return msg;
    }
    public void setAddresserId(Long addresserId) 
    {
        this.addresserId = addresserId;
    }

    public Long getAddresserId() 
    {
        return addresserId;
    }
    public void setAddresseeId(Long addresseeId) 
    {
        this.addresseeId = addresseeId;
    }

    public Long getAddresseeId() 
    {
        return addresseeId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("msg", getMsg())
            .append("uName", getuName())
            .append("phonenumber", getPhonenumber())
            .append("ctName", getCtName())
            .append("tel", getTel())
            .append("sex", getSex())
            .append("addresserId", getAddresserId())
            .append("addresseeId", getAddresseeId())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
