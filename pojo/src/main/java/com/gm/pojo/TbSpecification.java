package com.gm.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSpecification implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_specification.id
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_specification.spec_name
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    private String specName;


    private List<TbSpecificationOption> specificationOptionList;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_specification.id
     *
     * @return the value of tb_specification.id
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_specification.id
     *
     * @param id the value for tb_specification.id
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_specification.spec_name
     *
     * @return the value of tb_specification.spec_name
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_specification.spec_name
     *
     * @param specName the value for tb_specification.spec_name
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}