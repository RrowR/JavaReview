package com.study;

import org.junit.Test;

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
}
