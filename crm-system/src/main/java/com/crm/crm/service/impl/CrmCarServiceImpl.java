package com.crm.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmCarMapper;
import com.crm.crm.domain.CrmCar;
import com.crm.crm.service.ICrmCarService;
import com.crm.common.core.text.Convert;

/**
 * carService业务层处理
 * 
 * @author crm
 * @date 2020-03-06
 */
@Service
public class CrmCarServiceImpl implements ICrmCarService 
{
    @Autowired
    private CrmCarMapper crmCarMapper;

    /**
     * 查询car
     * 
     * @param id carID
     * @return car
     */
    @Override
    public CrmCar selectCrmCarById(Long id)
    {
        return crmCarMapper.selectCrmCarById(id);
    }

    /**
     * 查询car列表
     * 
     * @param crmCar car
     * @return car
     */
    @Override
    public List<CrmCar> selectCrmCarList(CrmCar crmCar)
    {
        return crmCarMapper.selectCrmCarList(crmCar);
    }

    /**
     * 查询所有汽车
     *
     * @return 汽车列表
     */
    @Override
    public List<CrmCar> selectCrmCarAll()
    {
        return crmCarMapper.selectCrmCarAll();
    }
    public List<CrmCar> selectCrmCarhomeLimit()
    {
        return crmCarMapper.selectCrmCarhomeLimit();
    }
    /**
     * 新增car
     * 
     * @param crmCar car
     * @return 结果
     */
    @Override
    public int insertCrmCar(CrmCar crmCar)
    {
        return crmCarMapper.insertCrmCar(crmCar);
    }

    /**
     * 修改car
     * 
     * @param crmCar car
     * @return 结果
     */
    @Override
    public int updateCrmCar(CrmCar crmCar)
    {
        return crmCarMapper.updateCrmCar(crmCar);
    }

    /**
     * 删除car对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmCarByIds(String ids)
    {
        return crmCarMapper.deleteCrmCarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除car信息
     * 
     * @param id carID
     * @return 结果
     */
    @Override
    public int deleteCrmCarById(Long id)
    {
        return crmCarMapper.deleteCrmCarById(id);
    }
}
