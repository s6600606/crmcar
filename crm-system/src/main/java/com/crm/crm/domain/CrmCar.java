package com.crm.crm.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.crm.common.annotation.Excel;
import com.crm.common.core.domain.BaseEntity;
import sun.applet.Main;

import java.util.Date;

/**
 * 【请填写功能名称】对象 crm_car
 *
 * @author crm
 * @date 2020-03-06
 */
public class CrmCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 汽车ID */
    private Long id;

    /** 汽车品牌 */
    @Excel(name = "汽车品牌")
    private String brand;

    /** 汽车级别 */
    @Excel(name = "汽车级别")
    private String grade;

    /** 车名 */
    @Excel(name = "车名")
    private String name;

    /** 车型 */
    @Excel(name = "车型")
    private String style;

    /** 上市时间 */
    @Excel(name = "上市时间", width = 10, dateFormat = "yyyy-MM-dd")
    private Date marketTime;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 图片 */
    @Excel(name = "图片")
    private String image;

    /** 库存 */
    @Excel(name = "库存")
    private Long carCount;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 发动机 */
    @Excel(name = "发动机")
    private String engine;

    /** 动力类型 */
    @Excel(name = "动力类型")
    private String power;

    /** 最高速度(km/h) */
    @Excel(name = "最高速度(km/h)")
    private Double topSpeed;

    /** 长宽高 */
    @Excel(name = "长宽高")
    private String lwh;

    /** 0-100加速时间(s) */
    @Excel(name = "0-100加速时间(s)")
    private Double acctime;

    /** 油耗(L/100km) */
    @Excel(name = "油耗(L/100km)")
    private Double fuelconsump;

    /** 汽车*/
    @Excel(name = "汽车")
    private String car;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getStyle()
    {
        return style;
    }
    public void setMarketTime(Date marketTime)
    {
        this.marketTime = marketTime;
    }

    public Date getMarketTime()
    {
        return marketTime;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getImage()
    {
        return image;
    }
    public void setCarCount(Long carCount)
    {
        this.carCount = carCount;
    }

    public Long getCarCount()
    {
        return carCount;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setEngine(String engine)
    {
        this.engine = engine;
    }

    public String getEngine()
    {
        return engine;
    }
    public void setPower(String power)
    {
        this.power = power;
    }

    public String getPower()
    {
        return power;
    }
    public void setTopSpeed(Double topSpeed)
    {
        this.topSpeed = topSpeed;
    }

    public Double getTopSpeed()
    {
        return topSpeed;
    }
    public void setLwh(String lwh)
    {
        this.lwh = lwh;
    }

    public String getLwh()
    {
        return lwh;
    }
    public void setAcctime(Double acctime)
    {
        this.acctime = acctime;
    }

    public Double getAcctime()
    {
        return acctime;
    }
    public void setFuelconsump(Double fuelconsump)
    {
        this.fuelconsump = fuelconsump;
    }

    public Double getFuelconsump()
    {
        return fuelconsump;
    }

    @Override
    public String toString() {
        System.out.println(getMarketTime());
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("brand", getBrand())
            .append("grade", getGrade())
            .append("name", getName())
            .append("style", getStyle())
            .append("marketTime", getMarketTime())
            .append("price", getPrice())
            .append("image", getImage())
            .append("carCount", getCarCount())
            .append("sort", getSort())
            .append("engine", getEngine())
            .append("power", getPower())
            .append("topSpeed", getTopSpeed())
            .append("lwh", getLwh())
            .append("acctime", getAcctime())
            .append("fuelconsump", getFuelconsump())
            .append("car", getCar())
            .toString();
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
