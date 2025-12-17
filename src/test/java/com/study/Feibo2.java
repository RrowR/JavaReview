package com.study;

/**
 * @author: Rrow
 * @date: 2025/6/8 21:22
 * Description:
 */
public class Feibo2 {
    public static int recursive(int a) {
        if (a == 0) return 0;
        int b = 0;
        int c = 1;
        for (int i = 2; i <= a; i++) {
            int temp = c;
            c = b + c;
            b = temp;

        }
        return c;


    }

    public static void main(String[] args) {
        System.out.println(recursive(10));
    }
}
