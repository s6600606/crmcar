package com.crm.crm.mapper;

import com.crm.crm.domain.CrmOrderStandard;
import java.util.List;

/**
 * 业绩目标Mapper接口
 * 
 * @author crm
 * @date 2020-05-05
 */
public interface CrmOrderStandardMapper 
{
    /**
     * 查询业绩目标
     * 
     * @param id 业绩目标ID
     * @return 业绩目标
     */
    public CrmOrderStandard selectCrmOrderStandardById(Long id);

    /**
     * 查询业绩目标列表
     * 
     * @param crmOrderStandard 业绩目标
     * @return 业绩目标集合
     */
    public List<CrmOrderStandard> selectCrmOrderStandardList(CrmOrderStandard crmOrderStandard);

    /**
     * 新增业绩目标
     * 
     * @param crmOrderStandard 业绩目标
     * @return 结果
     */
    public int insertCrmOrderStandard(CrmOrderStandard crmOrderStandard);

    /**
     * 修改业绩目标
     * 
     * @param crmOrderStandard 业绩目标
     * @return 结果
     */
    public int updateCrmOrderStandard(CrmOrderStandard crmOrderStandard);

    /**
     * 删除业绩目标
     * 
     * @param id 业绩目标ID
     * @return 结果
     */
    public int deleteCrmOrderStandardById(Long id);

    /**
     * 批量删除业绩目标
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCrmOrderStandardByIds(String[] ids);
}
