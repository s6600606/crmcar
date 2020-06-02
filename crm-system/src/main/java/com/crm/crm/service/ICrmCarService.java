package com.crm.crm.service;

import com.crm.crm.domain.CrmCar;

import java.util.List;

/**
 * carService接口
 * 
 * @author crm
 * @date 2020-03-06
 */
public interface ICrmCarService 
{
    /**
     * 查询car
     * 
     * @param id carID
     * @return car
     */
    public CrmCar selectCrmCarById(Long id);

    /**
     * 查询car列表
     * 
     * @param crmCar car
     * @return car集合
     */
    public List<CrmCar> selectCrmCarList(CrmCar crmCar);

    /**
     * 查询所有车
     *
     * @return 汽车列表
     */
    public List<CrmCar> selectCrmCarAll();
    public List<CrmCar> selectCrmCarhomeLimit();

    /**
     * 新增car
     * 
     * @param crmCar car
     * @return 结果
     */
    public int insertCrmCar(CrmCar crmCar);

    /**
     * 修改car
     * 
     * @param crmCar car
     * @return 结果
     */
    public int updateCrmCar(CrmCar crmCar);

    /**
     * 批量删除car
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmCarByIds(String ids);

    /**
     * 删除car信息
     * 
     * @param id carID
     * @return 结果
     */
    public int deleteCrmCarById(Long id);
}
