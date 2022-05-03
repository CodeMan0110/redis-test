package com.tangjie.redistest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisTestApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void test1() {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int count = 0;
                for (; ; ) {
                    System.out.println("----->1  " + count++);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int count = 0;
                for (; ; ) {
                    Thread.yield();
                    System.out.println("        ----->2  " + count++);
                }
            }
        };

        t1.start();
        t2.start();


    }

}
