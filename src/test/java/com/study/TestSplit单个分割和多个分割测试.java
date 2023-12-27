package com.study;

import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2023/11/27 16:15
 * Description:
 */
public class TestSplit单个分割和多个分割测试 {

    // 没有逗号得时候,看来也不会报错
    @Test
    public void test01() {
        String str = "sdadsa";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }


    }
}
