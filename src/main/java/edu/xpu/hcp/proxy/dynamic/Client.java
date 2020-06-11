package edu.xpu.hcp.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);
        Subject subject = (Subject)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), invocationHandler);
        subject.request();
    }
}
