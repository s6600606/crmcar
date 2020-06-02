package com.crm.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 反馈消息对象 crm_message
 * 
 * @author crm
 * @date 2020-04-07
 */
public class CrmMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息ID */
    private Long id;

    /** 消息标题 */
    @Excel(name = "消息标题")
    private String title;

    /** 消息主体 */
    @Excel(name = "消息主体")
    private String msg;

    /** 发信人用户名 */
    @Excel(name = "发信人用户名")
    private String uName;
    /** 发信人电话 */
    @Excel(name = "发信人电话")
    private String phonenumber;
    /** 收信人用户名 */
    @Excel(name = "收信人用户名")
    private String ctName;
    /** 收信人电话 */
    @Excel(name = "收信人电话")
    private String tel;
    /** 收信人性别 */
    @Excel(name = "收信人性别")
    private String sex;



    /** 发信人 */
    @Excel(name = "发信人")
    private Long addresserId;

    /** 收信人 */
    @Excel(name = "收信人")
    private Long addresseeId;

    /** 信息时间 */
    @Excel(name = "信息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

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

    public Long getAddresserId() {
        return addresserId;
    }

    public void setAddresserId(Long addresserId) {
        this.addresserId = addresserId;
    }

    public Long getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(Long addresseeId) {
        this.addresseeId = addresseeId;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
