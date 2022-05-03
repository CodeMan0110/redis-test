package com.tangjie.redistest.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Test2 {


    public static void main(String[] args) {
        int i = 0;
        ExecutorService service = Executors.newFixedThreadPool(10);
        final CountDownLatch latchCount = new CountDownLatch(i);
        for (; i < 100; i++) {
            service.execute(()->{
                ExecutorService service1 = Executors.newFixedThreadPool(10);

            });
        }
    }


    private void oprate1(ExecutorService service){

    }


    private void delete(){

    }
}
