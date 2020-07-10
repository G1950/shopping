package com.gm.mapper;

import com.gm.pojo.TbFreightTemplate;
import com.gm.pojo.TbFreightTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFreightTemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int countByExample(TbFreightTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int deleteByExample(TbFreightTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int insert(TbFreightTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int insertSelective(TbFreightTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    List<TbFreightTemplate> selectByExample(TbFreightTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    TbFreightTemplate selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByExampleSelective(@Param("record") TbFreightTemplate record, @Param("example") TbFreightTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByExample(@Param("record") TbFreightTemplate record, @Param("example") TbFreightTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByPrimaryKeySelective(TbFreightTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_freight_template
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByPrimaryKey(TbFreightTemplate record);
}