package com.study;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Rrow
 * @date: 2025/6/8 21:22
 * Description:
 */
public class TestMain {

    public static void changeStr(String str) {
        str = "Welcome";
    }

    public static void main(String[] args) {
        String str = "12345";
        changeStr(str);
        System.out.println(str);
    }
}
