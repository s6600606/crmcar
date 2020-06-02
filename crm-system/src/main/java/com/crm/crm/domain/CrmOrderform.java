package com.crm.crm.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 合同对象 crm_contract
 * 
 * @author crm
 * @date 2020-03-10
 */
public class CrmOrderform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 下单时间 */
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Long contractAmount;

    /** 销售员 */
    @Excel(name = "销售员")
    private String salesperson;


    /** 汽车id*/
    @Excel(name = "汽车id")
    private Long carId;

    /** 汽车*/
    @Excel(name = "汽车")
    private String carName;

    private Long count;

    private Double sum;
//    private Date beginTime;
//    private Date endTime;


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



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderTime", getOrderTime())
            .append("contractAmount", getContractAmount())
            .append("salesperson", getSalesperson())
            .append("carId", getCarId())
            .append("carName",getCarName())
            .append("sum", getSum())
            .append("count", getCount())
            .toString();
    }


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

}
