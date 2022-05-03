package com.tangjie.redistest.test;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Test5 {

    public static void main(String[] args) {

    }


}

//连接池
class Pool {

    //1、连接池大小
    private final int poolsize;


    private Connection[] connections;

    private AtomicIntegerArray states;


    Pool(int poolsize) {
        this.poolsize = poolsize;
    }
}
