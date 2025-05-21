package com.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rrow
 * @date: 2023/8/27 23:16
 * Description:
 */
public class Test扩容 {
    @Test
    public void test01() {
        int a = 10;
        int b = 10 + (10 >> 1);
        System.out.println("b = " + b);
    }

    @Test
    public void roundTest() {
        long l = Math.round(-1.5);
        System.out.println("l = " + l);
    }

    @Test
    public void splitTest() {
        String str1 = "黄、小";
        String str2 = "小";
        String[] split = str2.split("、");
        for (String s : split) {
            System.out.println(s);
        }

    }

    @Test
    public void listAdd() {
        List<String> list = new ArrayList<>();
        List<String> data = new ArrayList<>();
        for (String s : list) {
            data.add(s);
        }





    }
}
