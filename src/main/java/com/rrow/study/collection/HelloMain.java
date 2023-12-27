package com.rrow.study.collection;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Rrow
 * @date: 2023/8/14 15:45
 * Description:
 */
public class HelloMain {
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        i.getAndIncrement();
                        Thread.sleep((long) Math.random());
                        System.out.println("i = " + i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            pool.submit(thread);
        }

        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        i.getAndDecrement();
                        Thread.sleep(1000);
                        System.out.println("i = " + i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            pool.submit(thread);
        }

    }
}
