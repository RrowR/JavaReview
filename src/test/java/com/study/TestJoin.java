package com.study;

import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2023/12/27 17:36
 * Description:
 */
public class TestJoin {
    @Test
    public void join01() {
        String[] strArray = {"a","b","c"};
        String join = String.join(",", strArray);
        System.out.println(join);
    }
}
