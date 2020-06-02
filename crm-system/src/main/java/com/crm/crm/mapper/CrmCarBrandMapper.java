package com.crm.crm.mapper;

import com.crm.crm.domain.CrmCarBrand;
import java.util.List;

/**
 * 汽车名Mapper接口
 * 
 * @author crm
 * @date 2020-04-23
 */
public interface CrmCarBrandMapper 
{
    /**
     * 查询汽车名
     * 
     * @param id 汽车名ID
     * @return 汽车名
     */
    public CrmCarBrand selectCrmCarBrandById(Long id);

    /**
     * 查询汽车名列表
     * 
     * @param crmCarBrand 汽车名
     * @return 汽车名集合
     */
    public List<CrmCarBrand> selectCrmCarBrandList(CrmCarBrand crmCarBrand);

    /**
     * 新增汽车名
     * 
     * @param crmCarBrand 汽车名
     * @return 结果
     */
    public int insertCrmCarBrand(CrmCarBrand crmCarBrand);

    /**
     * 修改汽车名
     * 
     * @param crmCarBrand 汽车名
     * @return 结果
     */
    public int updateCrmCarBrand(CrmCarBrand crmCarBrand);

    /**
     * 删除汽车名
     * 
     * @param id 汽车名ID
     * @return 结果
     */
    public int deleteCrmCarBrandById(Long id);

    /**
     * 批量删除汽车名
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmCarBrandByIds(String[] ids);
}
