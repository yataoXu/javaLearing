package com.yatao.jvm.oom;

/**
 * 栈溢出错误
 *
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        StackOverFlow();

    }

    private static void StackOverFlow() {
        // Exception in thread "main" java.lang.StackOverflowError
        StackOverFlow();
    }
}
