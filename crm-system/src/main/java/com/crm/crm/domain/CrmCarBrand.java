package com.crm.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 汽车名对象 crm_car_brand
 * 
 * @author crm
 * @date 2020-04-23
 */
public class CrmCarBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 汽车名 */
    @Excel(name = "汽车名")
    private String carbrand;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarbrand(String carbrand) 
    {
        this.carbrand = carbrand;
    }

    public String getCarbrand() 
    {
        return carbrand;
    }

    public Date getCreateTime()
    {
        return createtime;
    }

    public void setCreateTime(Date createtime)
    {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carbrand", getCarbrand())
            .append("createtime", getCreateTime())
            .toString();
    }
}
