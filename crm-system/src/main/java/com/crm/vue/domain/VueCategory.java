package com.crm.vue.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;

/**
 * 分类对象 vue_category
 * 
 * @author crm
 * @date 2020-08-04
 */
public class VueCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private Long typeId;

    /** null */
    @Excel(name = "null")
    private String title;

    /** null */
    @Excel(name = "null")
    private String maitKey;

    /** null */
    @Excel(name = "null")
    private String miniWallkey;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setMaitKey(String maitKey) 
    {
        this.maitKey = maitKey;
    }

    public String getMaitKey() 
    {
        return maitKey;
    }
    public void setMiniWallkey(String miniWallkey) 
    {
        this.miniWallkey = miniWallkey;
    }

    public String getMiniWallkey() 
    {
        return miniWallkey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeId", getTypeId())
            .append("title", getTitle())
            .append("maitKey", getMaitKey())
            .append("miniWallkey", getMiniWallkey())
            .toString();
    }
}
