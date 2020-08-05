package com.crm.vue.domain;

import java.util.Date;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 评论对象 vue_det_rate
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueDetRate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 评论 */
    @Excel(name = "评论")
    private String content;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 显示时间 */
    @Excel(name = "显示时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date showDate;

    /** null */
    @Excel(name = "null")
    private String style;

    /** 图片 */
    @Excel(name = "图片")
    private String images;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCreated(Date created) 
    {
        this.created = created;
    }

    public Date getCreated() 
    {
        return created;
    }
    public void setShowDate(Date showDate) 
    {
        this.showDate = showDate;
    }

    public Date getShowDate() 
    {
        return showDate;
    }
    public void setStyle(String style) 
    {
        this.style = style;
    }

    public String getStyle() 
    {
        return style;
    }
    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("created", getCreated())
            .append("showDate", getShowDate())
            .append("style", getStyle())
            .append("images", getImages())
            .toString();
    }
}
