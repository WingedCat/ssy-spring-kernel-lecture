package edu.xpu.hcp.proxy.staticProxy;



public class Client {
    public static void main(String[] args) {
        Target target = new ProxyTarget(new RealTarget());
        target.request();
    }
}
