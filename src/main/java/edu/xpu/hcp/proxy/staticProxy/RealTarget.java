package edu.xpu.hcp.proxy.staticProxy;

/**
 * 真实对象
 */
public class RealTarget implements Target {
    @Override
    public void request() {
        System.out.println("From Real Target");
    }
}
