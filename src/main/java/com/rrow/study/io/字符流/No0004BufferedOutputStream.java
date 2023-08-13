package com.rrow.study.io.字符流;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/13 14:12
 * Description: 字节缓冲输出流 BufferedOutputStream
 */
public class No0004BufferedOutputStream {
    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
            byte[] array = "JavaGuide".getBytes();
            bos.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
