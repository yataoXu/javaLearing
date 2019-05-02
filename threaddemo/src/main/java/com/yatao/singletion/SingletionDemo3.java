package com.yatao.singletion;

public class SingletionDemo3 {
    private static SingletionDemo3 instance ;

    private SingletionDemo3(){
    }

    public static SingletionDemo3 getInstance(){
        if (instance == null){
            instance = new SingletionDemo3();
        }
        return instance;
    }

}
