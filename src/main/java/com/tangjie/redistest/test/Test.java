package com.tangjie.redistest.test;

public class Test {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int count = 0;
                for (; ; ) {
                    Thread.yield();
                    System.out.println("----->1  " + count++);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int count = 0;
                for (; ; ) {

                    System.out.println("        ----->2  " + count++);
                }
            }
        };
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
