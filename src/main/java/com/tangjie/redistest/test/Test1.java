package com.tangjie.redistest.test;


public class Test1 {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("lock a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                try {
//                    a.wait(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (b) {
                    System.out.println("t1执行");
                }
            }

        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("lock b");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("t2执行");
                }
            }

        }, "t2");

        t1.start();
        t2.start();

    }
}
