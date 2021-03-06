package com.gm.mapper;

import com.gm.pojo.TbItemCat;
import com.gm.pojo.TbItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int countByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int deleteByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int insert(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int insertSelective(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    List<TbItemCat> selectByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    TbItemCat selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByPrimaryKeySelective(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    int updateByPrimaryKey(TbItemCat record);
}