package com.algebra.dubbo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author al
 * @date 2019/7/2 16:59
 * @description
 */
@Data
public class SayHello implements Serializable {
    private String name;
    private String clientId;
}
