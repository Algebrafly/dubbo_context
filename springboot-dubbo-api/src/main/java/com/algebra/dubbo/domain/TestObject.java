package com.algebra.dubbo.domain;

/**
 * @author al
 * @date 2019/7/2 16:59
 * @description
 */
public class TestObject {

    private String name;
    private String hello;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "name='" + name + '\'' +
                ", hello='" + hello + '\'' +
                '}';
    }
}
