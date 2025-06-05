package com.rrow.study.安全集合;

import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2023/8/28 0:50
 * Description:
 */
public class No0002同步队列 {
    @Test
    public void test01() {
        Thread thread = new Thread(() -> System.out.println("xxx"));
        thread.start();
        thread.start();
        thread.interrupt();

    }
}
