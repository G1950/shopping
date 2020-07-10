package com.gm.common;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageResult
 * @Description 分页响应数据
 * @Author Gm
 * @Date 2020/7/8/008 10:26
 * @Version 1.0
 **/
public class PageResult implements Serializable {
    private Long total; //总数
    private List<?> rows; //返回的数量

    public PageResult() {

    }

    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public static PageResult build(Long total, List<?> rows) {
        return new PageResult(total, rows);
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
