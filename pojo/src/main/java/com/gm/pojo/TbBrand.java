package com.gm.pojo;

public class TbBrand {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_brand.id
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_brand.name
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_brand.first_char
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    private String firstChar;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_brand.id
     *
     * @return the value of tb_brand.id
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_brand.id
     *
     * @param id the value for tb_brand.id
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_brand.name
     *
     * @return the value of tb_brand.name
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_brand.name
     *
     * @param name the value for tb_brand.name
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_brand.first_char
     *
     * @return the value of tb_brand.first_char
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public String getFirstChar() {
        return firstChar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_brand.first_char
     *
     * @param firstChar the value for tb_brand.first_char
     *
     * @mbggenerated Tue Jul 07 10:14:01 CST 2020
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar == null ? null : firstChar.trim();
    }
}