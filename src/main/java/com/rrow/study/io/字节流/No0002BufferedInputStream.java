package com.rrow.study.io.字节流;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/9 17:56
 * Description: 缓冲输入流
 */
public class No0002BufferedInputStream {
    public static void main(String[] args) throws IOException {
        // 新建一个 BufferedInputStream 对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"));
        // 读取文件的内容并复制到 String 对象中
        byte[] bytes = bufferedInputStream.readAllBytes();
        String result = new String(bytes);
        System.out.println(result);
    }
}
