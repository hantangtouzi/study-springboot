package com.hantangtouzi.simplejdbcdemo;

/**
 * @author WilliamChang.
 * Created on 2019-06-16 21:18:13
 */

public class Foo {
    private Long id;
    private String bar;

    public Foo() {
    }

    public Foo(Long id, String bar) {
        this.id = id;
        this.bar = bar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
