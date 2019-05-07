package proxy;


public class HelloWorldTest {
    public static void main(String[] args) {

        HelloWorld helloWorld1 = new HelloWorldImpl();

        HelloWorld helloWorld = new HelloWorldProxy(helloWorld1);
        helloWorld.print();
    }
}
