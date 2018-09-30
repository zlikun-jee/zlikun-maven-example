package com.zlikun.jee.service.impl;

import com.zlikun.jee.service.HelloService;

/**
 * @author zlikun
 * @date 2018-09-17 17:59
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return String.format("Hello %s !", name);
    }
}
