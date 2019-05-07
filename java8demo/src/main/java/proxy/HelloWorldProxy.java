package proxy;

/**
 * 静态代理总结:
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 *
 * 因为代理对象需要与目标对象实现一样的接口,
 * 所以会有很多代理类,类太多.
 * 同时,一旦接口增加方法,目标对象与代理对象都要维护.
 */
public class HelloWorldProxy implements HelloWorld {

    private final HelloWorld helloWorld;

    public HelloWorldProxy(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public void print() {
        before();
        helloWorld.print();
        after();

    }

    private void before() {

        System.out.println("开始事务...");
    }

    private void after() {
        System.out.println("提交事务...");
    }
}
