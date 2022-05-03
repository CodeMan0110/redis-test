package com.tangjie.redistest.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Test9 {

    public static void main(String[] args) {

        if (false || true && true) {
            System.out.println("false || true && true");
        }

        if (false || false && true) {
            System.out.println("false || false && true");
        }

        if (false || false || true && true) {
            System.out.println("false || false || true && true");
        }

        if (false || false || true && false) {
            System.out.println("false || false || true && false");
        }


        if (false || true || false && false) {
            System.out.println("false || true || false && false");
        }

        int i = 0;
        System.out.println("i走判断之前的值" + i);
        if (false || false || ++i != 0 && ++i == 0) {
            System.out.println("false || false || ++i != 0 && false");
        }
        System.out.println("i走判断之后的值" + i);


        if (false || false || true && false) {
            System.out.println("false || false || true && true");
        }


        int a = 0;
        System.out.println("a走判断之前的值" + a);
        if (false || true || (++a == 0 && false)) {
            System.out.println("false || true || ++a == 0 && false");
        }
        System.out.println("a走判断之后的值" + a);


        if ((false || true || false) && false) {
            System.out.println("(false || true || false) && false");
        }

        if (false || true || false && false) {
            System.out.println("false || true || false && false");
        }


        int a1 = 0;
        System.out.println("a1走判断之前的值" + a1);
        if (false | true | (++a1 == 0 && false)) {
            System.out.println("false | true | (++a1 == 0 && false)");
        }
        System.out.println("a1走判断之后的值" + a1);


        if (true && sout(false)) {
            System.out.println("我擦");
        }
    }

    public static boolean sout(boolean bool) {
        System.out.println("输入结果为：" + bool);
        return bool;
    }

}
