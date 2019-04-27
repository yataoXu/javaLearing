package com.yatao.threads;

import lombok.*;

import java.util.concurrent.atomic.AtomicReference;

@Data
class User {
    String userName;
    int age;


    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference();

        User z3 = new User("zhangsan", 23);
        User li4 = new User("lisi", 25);

        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\n" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\n" + atomicReference.get());

    }
}