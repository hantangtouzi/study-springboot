package com.hantangtouzi.datatable.result;

import java.io.Serializable;

/**
 * 分页结果Bean.
 *
 * @author WilliamChang.
 * Created on 2018/10/14 13:06
 */

public class PagedResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int CHECK_FAIL = 1;

    public static final int NO_PERMISSION = 2;

    public static final int UNKNOWN_EXCEPTION = -99;

    private String message = "success";

    private int code = SUCCESS;

    private Long draw;

    private Long recordsTotal;

    private Long recordsFiltered;

    private T data;

    public PagedResultBean() {
        super();
    }

    public PagedResultBean(T data) {
        super();
        this.data = data;
    }

    public PagedResultBean(T data, Long draw, Long recordsTotal, Long recordsFiltered) {
        super();
        this.data = data;
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public PagedResultBean(Throwable e) {
        super();
        this.message = e.toString();
        this.code = UNKNOWN_EXCEPTION;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
