package com.crm.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;

/**
 * 业绩目标对象 crm_order_standard
 * 
 * @author crm
 * @date 2020-05-05
 */
public class CrmOrderStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 公司月销售额 */
    @Excel(name = "公司月销售额")
    private Double monthAmount;

    /** 公司年销售额 */
    @Excel(name = "公司年销售额")
    private Double yearAmount;

    /** 公司月订单数 */
    @Excel(name = "公司月订单数")
    private Long monthOrder;

    /** 公司年订单数 */
    @Excel(name = "公司年订单数")
    private Long yearOrder;

    /** 个人月销售额 */
    @Excel(name = "个人月销售额")
    private Double monthAamount;

    /** 个人月订单数 */
    @Excel(name = "个人月订单数")
    private Long monthAorder;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMonthAmount(Double monthAmount) 
    {
        this.monthAmount = monthAmount;
    }

    public Double getMonthAmount() 
    {
        return monthAmount;
    }
    public void setYearAmount(Double yearAmount) 
    {
        this.yearAmount = yearAmount;
    }

    public Double getYearAmount() 
    {
        return yearAmount;
    }
    public void setMonthOrder(Long monthOrder) 
    {
        this.monthOrder = monthOrder;
    }

    public Long getMonthOrder() 
    {
        return monthOrder;
    }
    public void setYearOrder(Long yearOrder) 
    {
        this.yearOrder = yearOrder;
    }

    public Long getYearOrder() 
    {
        return yearOrder;
    }
    public void setMonthAamount(Double monthAamount) 
    {
        this.monthAamount = monthAamount;
    }

    public Double getMonthAamount() 
    {
        return monthAamount;
    }
    public void setMonthAorder(Long monthAorder) 
    {
        this.monthAorder = monthAorder;
    }

    public Long getMonthAorder() 
    {
        return monthAorder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("monthAmount", getMonthAmount())
            .append("yearAmount", getYearAmount())
            .append("monthOrder", getMonthOrder())
            .append("yearOrder", getYearOrder())
            .append("monthAamount", getMonthAamount())
            .append("monthAorder", getMonthAorder())
            .toString();
    }
}
