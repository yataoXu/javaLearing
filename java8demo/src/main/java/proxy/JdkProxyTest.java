package proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImpl();
        HelloWorld jdkProxy = (HelloWorld) new JdkProxy(helloWorld).getProxyInstance();
        jdkProxy.print();
    }
}
