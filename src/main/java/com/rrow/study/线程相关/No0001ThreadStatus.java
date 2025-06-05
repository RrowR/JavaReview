package com.rrow.study.线程相关;

import java.util.concurrent.TimeUnit;

/**
 * @author: Rrow
 * @date: 2023/8/26 16:27
 * Description: java线程中的几种等待状态
 * TIMED_WAITING    有时间的等待
 * WAITING          无限等待,只能被等待唤醒
 * BLOCKED          被锁阻塞
 */
public class No0001ThreadStatus {
    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);        // TIMED_WAITING
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "THREAD_1").start();   // 有时间的等待    sleep

        new Thread(() -> {
            synchronized (No0001ThreadStatus.class) {
                while (true) {
                    try {
                        No0001ThreadStatus.class.wait();    // WAITING
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "THREAD_2").start();      // 无限等待    wait

        // 锁等待阻塞   lock
        new Thread(new BlockDemo(), "THREAD_3").start();     // TIMED_WAITING
        new Thread(new BlockDemo(), "THREAD_4").start();     // BLOCKED


    }

    static class BlockDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
