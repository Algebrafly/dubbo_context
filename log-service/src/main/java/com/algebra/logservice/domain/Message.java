package com.algebra.logservice.domain;

import lombok.Data;

/**
 * @author al
 * @date 2019/8/7 9:07
 * @description
 */
@Data
public class Message {

    public static final Integer HELLO = 0;
    public static final Integer GOODBYE = 1;

    private String message;

    private Integer status;
}
