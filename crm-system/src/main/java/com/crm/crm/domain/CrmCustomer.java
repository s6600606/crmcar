package com.crm.crm.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 联系人对象 crm_contacts
 * 
 * @author crm
 * @date 2020-03-02
 */
public class CrmCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 登录名称 */
    @Excel(name = "登录名称")
    private String loginName;

    /** 密码 */
    private String pwd;

    /** 登录IP */
    @Excel(name = "登录IP")
    private String loginIp;

    /** 登录时间 */
    @Excel(name = "登录时间")
    private String loginDate;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String name;

    @Excel(name = "性别", readConverterExp = "0=男,1=女")
    private String sex;

    @Excel(name = "年龄")
    private Integer age;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String tel;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    @Excel(name = "职业")
    private String job;

    @Excel(name = "住址")
    private String address;

    /** 最后一次联系时间 */
    @Excel(name = "最后一次联系时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastContactTime;

    @Excel(name = "购车数量")
    private Integer buycarNum;

    @Excel(name = "备注")
    private String remark;



    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId() 
    {
        return id;
    }

    @NotBlank(message = "登录账号不能为空")
    @Size(min = 0, max = 30, message = "登录账号长度不能超过30个字符")
    public String getLoginName()
    {
        return loginName;
    }
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public String getName() 
    {
        return name;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public String getSex()
    {
        return sex;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
    public Integer getAge()
    {
        return age;
    }

    public void setTel(String tel) 
    {
        this.tel = tel;
    }
    @Size(min = 0, max = 11, message = "电话号码长度不超过11位")
    public String getTel() 
    {
        return tel;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
    public String getEmail() 
    {
        return email;
    }

    public void setJob(String job)
    {
        this.job = job;
    }
    public String getJob()
    {
        return job;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }

    public void setLastContactTime(Date lastContactTime) 
    {
        this.lastContactTime = lastContactTime;
    }

    public Date getLastContactTime() 
    {
        return lastContactTime;
    }

    public void setBuycarNum(Integer buycarNum)
    {
        this.buycarNum = buycarNum;
    }
    public Integer getBuycarNum()
    {
        return buycarNum;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    public String getRemark()
    {
        return remark;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loginName", getLoginName())
            .append("pwd", getPwd())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("tel", getTel())
            .append("email", getEmail())
            .append("job", getJob())
            .append("address", getAddress())
            .append("lastContactTime", getLastContactTime())
            .append("remark", getRemark())
            .append("buycarNum", getBuycarNum())
            .append("createTime", getCreateTime())
            .toString();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }
}
