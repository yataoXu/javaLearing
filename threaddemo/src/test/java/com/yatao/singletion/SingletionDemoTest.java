package com.yatao.singletion;


import org.junit.Test;

public class SingletionDemoTest {

    @Test
    public void getInstance() {
        System.out.println(SingletionDemo1.getInstance());
    }
    @Test
    public void getInstance2() {
        System.out.println(SingletionDemo2.getInstance());
    }
    @Test
    public void getInstance3() {
        System.out.println(SingletionDemo3.getInstance());
        System.out.println(SingletionDemo3.getInstance());
        System.out.println(SingletionDemo3.getInstance());
        System.out.println(SingletionDemo3.getInstance());
        System.out.println(SingletionDemo3.getInstance());
    }

    @Test
    public void getInstance4() {
        System.out.println(SingletionDemo4.INSTANCE);
        System.out.println(SingletionDemo4.INSTANCE);
        System.out.println(SingletionDemo4.INSTANCE);
        System.out.println(SingletionDemo4.INSTANCE);
        System.out.println(SingletionDemo4.INSTANCE);
    }

    @Test
    public void SingletonDemo5() {
        System.out.println(SingletonDemo5.getSinglet());
        System.out.println(SingletonDemo5.getSinglet());
        System.out.println(SingletonDemo5.getSinglet());
        System.out.println(SingletonDemo5.getSinglet());
    }


}
