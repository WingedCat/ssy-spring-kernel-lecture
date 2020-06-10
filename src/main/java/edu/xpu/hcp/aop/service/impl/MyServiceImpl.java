package edu.xpu.hcp.aop.service.impl;

import edu.xpu.hcp.aop.service.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("MyServiceImpl Invoke...");
    }
}
