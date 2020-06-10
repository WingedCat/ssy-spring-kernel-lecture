package edu.xpu.hcp.aop.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvisor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before MyAdvisor Invoke...");
        Object result = methodInvocation.proceed();
        System.out.println("After MyAdvisor Invoke...");
        return result;
    }
}
