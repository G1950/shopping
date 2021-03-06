package com.gm.mapper;

import com.gm.pojo.TbSpecification;
import com.gm.pojo.TbSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpecificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int countByExample(TbSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int deleteByExample(TbSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int insert(TbSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int insertSelective(TbSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    List<TbSpecification> selectByExample(TbSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    TbSpecification selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByExampleSelective(@Param("record") TbSpecification record, @Param("example") TbSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByExample(@Param("record") TbSpecification record, @Param("example") TbSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByPrimaryKeySelective(TbSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByPrimaryKey(TbSpecification record);
}