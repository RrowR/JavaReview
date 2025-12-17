package com.rrow.study;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Rrow
 * @date: 2025/6/6 01:26
 * Description: 锁机制
 */
public class TestMain {

    public static boolean t = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (t) {
            }
        }).start();
        Thread.sleep(2000);
        new Thread(() -> {
            t = false;
        }).start();


    }
}
