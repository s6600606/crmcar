package com.crm.system.domain;

import com.crm.common.annotation.Excel;
import com.crm.common.annotation.Excel.ColumnType;
import com.crm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class SysMain extends BaseEntity
{
    private List<Long> finish;
    private List<Long> noFinish;

    public List<Long> getFinish() {
        return finish;
    }

    public void setFinish(List<Long> finish) {
        this.finish = finish;
    }

    public List<Long> getNoFinish() {
        return noFinish;
    }

    public void setNoFinish(List<Long> noFinish) {
        this.noFinish = noFinish;
    }

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("finish", getFinish())
            .append("noFinish", getNoFinish())
            .toString();
    }
}
