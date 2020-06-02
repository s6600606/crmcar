package com.crm.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 预约信息对象 crm_appoint
 * 
 * @author crm
 * @date 2020-04-07
 */
public class CrmAppoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约id */
    private Long id;

    /** 预约车辆 */
    private String car;
    /** 预约人用户名 */
    private String loginName;
    /** 预约人姓名 */
    private String name;
    /** 预约人电话号码 */
    private String tel;
    /** 预约人性别 */
    private String sex;

    /** 联系人id */
    @Excel(name = "联系人id")
    private Long contactsId;

    /** 车辆id */
    @Excel(name = "车辆id")
    private Long carId;

    /** 预约时间 */
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setContactsId(Long contactsId) 
    {
        this.contactsId = contactsId;
    }

    public Long getContactsId() 
    {
        return contactsId;
    }
    public void setCarId(Long carId) 
    {
        this.carId = carId;
    }

    public Long getCarId() 
    {
        return carId;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("car", getCar())
            .append("loginName", getLoginName())
            .append("name", getName())
            .append("tel", getTel())
            .append("sex", getSex())
            .append("contactsId", getContactsId())
            .append("carId", getCarId())
            .append("time", getTime())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
