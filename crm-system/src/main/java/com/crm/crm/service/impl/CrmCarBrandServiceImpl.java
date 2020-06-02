package com.crm.crm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.crm.mapper.CrmCarBrandMapper;
import com.crm.crm.domain.CrmCarBrand;
import com.crm.crm.service.ICrmCarBrandService;
import com.crm.common.core.text.Convert;

/**
 * 汽车名Service业务层处理
 * 
 * @author crm
 * @date 2020-04-23
 */
@Service
public class CrmCarBrandServiceImpl implements ICrmCarBrandService 
{
    @Autowired
    private CrmCarBrandMapper crmCarBrandMapper;

    /**
     * 查询汽车名
     * 
     * @param id 汽车名ID
     * @return 汽车名
     */
    @Override
    public CrmCarBrand selectCrmCarBrandById(Long id)
    {
        return crmCarBrandMapper.selectCrmCarBrandById(id);
    }

    /**
     * 查询汽车名列表
     * 
     * @param crmCarBrand 汽车名
     * @return 汽车名
     */
    @Override
    public List<CrmCarBrand> selectCrmCarBrandList(CrmCarBrand crmCarBrand)
    {
        return crmCarBrandMapper.selectCrmCarBrandList(crmCarBrand);
    }

    /**
     * 新增汽车名
     * 
     * @param crmCarBrand 汽车名
     * @return 结果
     */
    @Override
    public int insertCrmCarBrand(CrmCarBrand crmCarBrand)
    {
        return crmCarBrandMapper.insertCrmCarBrand(crmCarBrand);
    }

    /**
     * 修改汽车名
     * 
     * @param crmCarBrand 汽车名
     * @return 结果
     */
    @Override
    public int updateCrmCarBrand(CrmCarBrand crmCarBrand)
    {
        return crmCarBrandMapper.updateCrmCarBrand(crmCarBrand);
    }

    /**
     * 删除汽车名对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrmCarBrandByIds(String ids)
    {
        return crmCarBrandMapper.deleteCrmCarBrandByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除汽车名信息
     * 
     * @param id 汽车名ID
     * @return 结果
     */
    @Override
    public int deleteCrmCarBrandById(Long id)
    {
        return crmCarBrandMapper.deleteCrmCarBrandById(id);
    }
}
