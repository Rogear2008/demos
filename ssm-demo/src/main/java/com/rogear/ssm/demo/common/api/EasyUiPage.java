package com.rogear.ssm.demo.common.api;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rogear2008
 * @time 2022/6/14 22:47
 */
public class EasyUiPage<T> implements Serializable {

    private static final long serialVersionUID = 5858421906459191481L;

    private String total;

    private List<T> rows;

    public EasyUiPage() {
    }

    public EasyUiPage(List<T> rows) {
        this.rows = rows;
        this.total = String.valueOf(rows.size());
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
