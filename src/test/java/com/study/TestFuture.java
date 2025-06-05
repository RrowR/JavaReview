package com.study;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author: Rrow
 * @date: 2023/8/26 16:49
 * Description:
 */
public class TestFuture {

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "haha");

        // future.get() 阻塞获取结果 ,上面是死循环等待,永远获取不了
        String result = future.get();
        System.out.println("result = " + result);

        executorService.shutdown();

    }

    @Test
    public void test02() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "haha");

        // 10秒钟之后获取结果,需要获取异常
        String result = future.get();
        System.out.println("result = " + result);

        executorService.shutdown();

    }

}
