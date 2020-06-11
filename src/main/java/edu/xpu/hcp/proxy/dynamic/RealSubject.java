package edu.xpu.hcp.proxy.dynamic;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("Realsubject ...");
    }
}
