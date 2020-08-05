package com.crm.vue.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品信息对象 vue_det_detailinfo
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueDetDetailinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private Long detailinfoId;

    /** null */
    @Excel(name = "null")
    private String descl;

    /** null */
    @Excel(name = "null")
    private String detailImage;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDetailinfoId(Long detailinfoId) 
    {
        this.detailinfoId = detailinfoId;
    }

    public Long getDetailinfoId() 
    {
        return detailinfoId;
    }
    public void setDescl(String descl)
    {
        this.descl = descl;
    }

    public String getDescl()
    {
        return descl;
    }
    public void setDetailImage(String detailImage) 
    {
        this.detailImage = detailImage;
    }

    public String getDetailImage() 
    {
        return detailImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("detailinfoId", getDetailinfoId())
            .append("descl", getDescl())
            .append("detailImage", getDetailImage())
            .toString();
    }
}
