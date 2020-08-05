package com.crm.vue.domain;

import java.math.BigDecimal;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品表对象 vue_homedata
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueHomedata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** iid */
    @Excel(name = "iid")
    private Long iid;
    private Long miniWallkey;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private Long typeId;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String img;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** null */
    @Excel(name = "null")
    private String cfav;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    private String type;

    private Long page;
    private Long page1;
    private Long page10;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIid(Long iid) 
    {
        this.iid = iid;
    }

    public Long getIid() 
    {
        return iid;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCfav(String cfav) 
    {
        this.cfav = cfav;
    }

    public String getCfav() 
    {
        return cfav;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("iid", getIid())
                .append("miniWallkey", getMiniWallkey())
            .append("typeId", getTypeId())
            .append("img", getImg())
            .append("price", getPrice())
            .append("cfav", getCfav())
            .append("title", getTitle())
            .append("type", getType())
            .append("page", getPage())
            .append("page1", getPage1())
            .append("page10", getPage10())
            .toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPage10() {
        return page10;
    }
    public Long getPage1() {
        return page1;
    }

    public void setPage1(Long page1) {
        this.page1 = page1;
    }

    public void setPage10(Long page10) {
        this.page10 = page10;
    }

    public Long getMiniWallkey() {
        return miniWallkey;
    }

    public void setMiniWallkey(Long miniWallkey) {
        this.miniWallkey = miniWallkey;
    }
}
