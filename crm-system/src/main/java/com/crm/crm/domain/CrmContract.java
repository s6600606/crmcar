package com.crm.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 合同对象 crm_contract
 * 
 * @author crm
 * @date 2020-03-10
 */
public class CrmContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同编号 */
    private Long id;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 下单时间 */
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Long contractAmount;

    /** 客户签约人 */
    @Excel(name = "客户签约人")
    private String customerSigner;

    /** 公司签约人 */
    @Excel(name = "公司签约人")
    private String companySigner;

    /** 销售员 */
    @Excel(name = "销售员")
    private String salesperson;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatetime;

    /** 汽车id*/
    @Excel(name = "汽车id")
    private Long carId;

    /** 汽车*/
    @Excel(name = "汽车")
    private String car;

    /** 备注*/
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
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setContractAmount(Long contractAmount) 
    {
        this.contractAmount = contractAmount;
    }

    public Long getContractAmount() 
    {
        return contractAmount;
    }
    public void setCustomerSigner(String customerSigner) 
    {
        this.customerSigner = customerSigner;
    }

    public String getCustomerSigner() 
    {
        return customerSigner;
    }
    public void setCompanySigner(String companySigner) 
    {
        this.companySigner = companySigner;
    }

    public String getCompanySigner() 
    {
        return companySigner;
    }
    public void setSalesperson(String salesperson) 
    {
        this.salesperson = salesperson;
    }

    public String getSalesperson() 
    {
        return salesperson;
    }
    public void setCarId(Long carId) 
    {
        this.carId = carId;
    }

    public Long getCarId() 
    {
        return carId;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contractName", getContractName())
            .append("customerName", getCustomerName())
            .append("orderTime", getOrderTime())
            .append("contractAmount", getContractAmount())
            .append("customerSigner", getCustomerSigner())
            .append("companySigner", getCompanySigner())
            .append("salesperson", getSalesperson())
            .append("remark", getRemark())
            .append("updatetime", getUpdatetime())
            .append("carId", getCarId())
            .append("car", getCar())
            .append("remark", getRemark())
            .toString();
    }


    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
