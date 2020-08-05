package com.crm.vue.domain;

import java.math.BigDecimal;
import java.util.List;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品信息对象 vue_det_iteminfo
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueDetIteminfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 商品标题 */
    @Excel(name = "商品标题")
    private String title;

    /** null */
    @Excel(name = "null")
    private String descl;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 旧价格 */
    @Excel(name = "旧价格")
    private BigDecimal oldPrice;

    /** null */
    @Excel(name = "null")
    private String discountDesc;

    /** 现在价格 */
    @Excel(name = "现在价格")
    private BigDecimal highNowPrice;

    /** 图片 */
    @Excel(name = "图片")
    private String topImages;

    private List listimg;

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
    public void setDesc(String descl)
    {
        this.descl = descl;
    }

    public String getDesc() 
    {
        return descl;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setOldPrice(BigDecimal oldPrice) 
    {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getOldPrice() 
    {
        return oldPrice;
    }
    public void setDiscountDesc(String discountDesc) 
    {
        this.discountDesc = discountDesc;
    }

    public String getDiscountDesc() 
    {
        return discountDesc;
    }
    public void setHighNowPrice(BigDecimal highNowPrice) 
    {
        this.highNowPrice = highNowPrice;
    }

    public BigDecimal getHighNowPrice() 
    {
        return highNowPrice;
    }
    public void setTopImages(String topImages)
    {
        this.topImages = topImages;
    }

    public String getTopImages()
    {
        return topImages;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("descl", getDesc())
            .append("price", getPrice())
            .append("oldPrice", getOldPrice())
            .append("discountDesc", getDiscountDesc())
            .append("highNowPrice", getHighNowPrice())
            .append("topImages", getTopImages())
                .append("listimg", getListimg())
            .toString();
    }


    public List getListimg() {
        return listimg;
    }

    public void setListimg(List listimg) {
        this.listimg = listimg;
    }
}
