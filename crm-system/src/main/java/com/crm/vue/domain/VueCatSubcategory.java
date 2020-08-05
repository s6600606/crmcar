package com.crm.vue.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;

/**
 * 具体分类对象 vue_cat_subcategory
 * 
 * @author crm
 * @date 2020-08-04
 */
public class VueCatSubcategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private String mailKey;

    /** null */
    @Excel(name = "null")
    private String image;

    /** null */
    @Excel(name = "null")
    private String title;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMailKey(String mailKey) 
    {
        this.mailKey = mailKey;
    }

    public String getMailKey() 
    {
        return mailKey;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
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
            .append("mailKey", getMailKey())
            .append("image", getImage())
            .append("title", getTitle())
            .toString();
    }
}
