package com.yatao.singletion;

public class SingletionDemo1 {

    private static final SingletionDemo1 instance =  new SingletionDemo1();

    private SingletionDemo1(){

    }

    public static SingletionDemo1 getInstance(){
        return instance;
    }

}
