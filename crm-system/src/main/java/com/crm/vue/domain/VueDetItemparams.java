package com.crm.vue.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品参数对象 vue_det_itemparams
 * 
 * @author crm
 * @date 2020-07-31
 */
public class VueDetItemparams extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private Long info;

    /** null */
    @Excel(name = "null")
    private Long rule;
    private String images;
    private String set;
    private String tables;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInfo(Long info)
    {
        this.info = info;
    }

    public Long getInfo()
    {
        return info;
    }
    public void setRule(Long rule)
    {
        this.rule = rule;
    }

    public Long getRule()
    {
        return rule;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("info", getInfo())
            .append("rule", getRule())
                .append("images", getImages())
                .append("set", getSet())
                .append("tables", getTables())
            .toString();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }
}
