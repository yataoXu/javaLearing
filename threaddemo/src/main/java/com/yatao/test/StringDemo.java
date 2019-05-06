package com.yatao.test;

public class StringDemo {
    public static void main(String[] args) {

        String s1 = new String();
        String s2 = new String();
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true


        String s3 = new String("123");
        String s4 = "123";
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // true

        String s5 = new String("123").intern();
        String s6 = "123";
        System.out.println(s5 == s6); // true
        System.out.println(s5.equals(s6)); // true

        Integer int1 = new Integer(100);
        Integer int2 = new Integer(100);
        System.out.println(int1 == int2); // false


        Integer int3 = new Integer(100);
        int int4 = 100;
        System.out.println(int3 == int4); //true

        Integer int5 = new Integer(100);
        Integer int6 = 100;
        System.out.println(int5 == int6); //false


    }
}
