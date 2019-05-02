package com.yatao.singletion;

public class SingletionDemo2 {
    private static SingletionDemo2 instance ;

    private SingletionDemo2(){
    }

    static {
        instance = new SingletionDemo2();
    }
    public static SingletionDemo2 getInstance(){

        return instance;
    }

}

