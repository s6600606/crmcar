package com.crm.vue.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家店铺对象 vue_det_shopinfo
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueDetShopinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private String services;

    /** 商店Logo */
    @Excel(name = "商店Logo")
    private String shopLogo;

    /** 店名 */
    @Excel(name = "店名")
    private String name;

    /** null */
    @Excel(name = "null")
    private String cFans;

    /** null */
    @Excel(name = "null")
    private String cSells;

    /** null */
    @Excel(name = "null")
    private String score;

    /**  */
    @Excel(name = "")
    private String cGoods;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setServices(String services) 
    {
        this.services = services;
    }

    public String getServices() 
    {
        return services;
    }
    public void setShopLogo(String shopLogo) 
    {
        this.shopLogo = shopLogo;
    }

    public String getShopLogo() 
    {
        return shopLogo;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setcFans(String cFans) 
    {
        this.cFans = cFans;
    }

    public String getcFans() 
    {
        return cFans;
    }
    public void setcSells(String cSells) 
    {
        this.cSells = cSells;
    }

    public String getcSells() 
    {
        return cSells;
    }
    public void setScore(String score) 
    {
        this.score = score;
    }

    public String getScore() 
    {
        return score;
    }
    public void setcGoods(String cGoods) 
    {
        this.cGoods = cGoods;
    }

    public String getcGoods() 
    {
        return cGoods;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("services", getServices())
            .append("shopLogo", getShopLogo())
            .append("name", getName())
            .append("cFans", getcFans())
            .append("cSells", getcSells())
            .append("score", getScore())
            .append("cGoods", getcGoods())
            .toString();
    }
}
