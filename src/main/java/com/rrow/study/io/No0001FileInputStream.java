package com.rrow.study.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: Rrow
 * @date: 2023/8/9 17:32
 * Description:
 */
public class No0001FileInputStream {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            System.out.println("available: " + fis.available());
            int content;
            // 忽略输入流中的 n 个字节 ,返回实际忽略的字节数
            long skip = fis.skip(2);
            System.out.println("skip: " + skip);
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
