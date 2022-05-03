package com.tangjie.redistest.test;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class Test8 {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.info("park");
            LockSupport.park();

        }, "t1");


        t1.start();
        Thread.sleep(1000);
        log.info("unPark");
        LockSupport.unpark(t1);
    }

}
