package edu.xpu.hcp.proxy.staticProxy;


/**
 * 代理对象，和真实对象一样都要实现Target接口
 */
public class ProxyTarget  implements Target {
    private Target target;

    public ProxyTarget(Target target){
        this.target = target;
    }

    @Override
    public void request() {
        System.out.println("Before...");
        target.request();
        System.out.println("After...");
    }
}
