package com.cisco.icam.specification_service.entity;

import java.util.List;

public class PageResult {
    private List rows;	// 结果集
    private long total;	// 总条数
    public PageResult(List rows, long total) {
        super();
        this.rows = rows;
        this.total = total;
    }

    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
}
