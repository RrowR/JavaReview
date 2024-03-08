package com.study;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Rrow
 * @date: 2024/2/28 23:46
 * Description:
 */
public class 测试全局变量到接口匿名函数 {
     public static void main(String[] args) {
          AtomicInteger i = new AtomicInteger();
          new Thread(() -> i.getAndIncrement()).start();
     }
}
