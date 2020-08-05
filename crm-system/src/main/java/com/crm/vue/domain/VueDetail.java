package com.crm.vue.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品详情对象 vue_detail
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long iid;

    /** 商品id */
    @Excel(name = "商品id")
    private Long iteminfoId;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopinfoId;

    /** null */
    @Excel(name = "null")
    private Long detailinfoId;

    /** 参数id */
    @Excel(name = "参数id")
    private Long itemparamsId;

    /** 评论id */
    @Excel(name = "评论id")
    private Long rateId;

    public void setIid(Long iid) 
    {
        this.iid = iid;
    }

    public Long getIid() 
    {
        return iid;
    }
    public void setIteminfoId(Long iteminfoId) 
    {
        this.iteminfoId = iteminfoId;
    }

    public Long getIteminfoId() 
    {
        return iteminfoId;
    }
    public void setShopinfoId(Long shopinfoId) 
    {
        this.shopinfoId = shopinfoId;
    }

    public Long getShopinfoId() 
    {
        return shopinfoId;
    }
    public void setDetailinfoId(Long detailinfoId) 
    {
        this.detailinfoId = detailinfoId;
    }

    public Long getDetailinfoId() 
    {
        return detailinfoId;
    }
    public void setItemparamsId(Long itemparamsId) 
    {
        this.itemparamsId = itemparamsId;
    }

    public Long getItemparamsId() 
    {
        return itemparamsId;
    }
    public void setRateId(Long rateId) 
    {
        this.rateId = rateId;
    }

    public Long getRateId() 
    {
        return rateId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("iid", getIid())
            .append("iteminfoId", getIteminfoId())
            .append("shopinfoId", getShopinfoId())
            .append("detailinfoId", getDetailinfoId())
            .append("itemparamsId", getItemparamsId())
            .append("rateId", getRateId())
            .toString();
    }
}
