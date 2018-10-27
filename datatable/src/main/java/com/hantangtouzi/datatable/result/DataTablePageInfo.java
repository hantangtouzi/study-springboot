package com.hantangtouzi.datatable.result;

/**
 * @Author: WilliamChang.
 * Created on 2018/10/14 13:56
 */

public class DataTablePageInfo extends PageInfo {
    private Long draw;

    private Long recordsTotal;

    private Long recordsFiltered;

    public Long getDraw() {
        return draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
