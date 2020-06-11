package edu.xpu.hcp.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
    private Object object;

    public DynamicSubject(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before ...");
        Object res = method.invoke(object, args);
        System.out.println("After ...");
        return res;
    }
}
