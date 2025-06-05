package com.study;

import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2023/8/28 22:16
 * Description:
 */
public class TestStringBuilder {

    @Test
    public void test01() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        System.out.println("stringBuilder.toString() = " + stringBuilder);
    }

}
