package com.rrow.study.io.字节流;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/12 9:20
 * Description: BufferedOutputStream
 */
public class No0006BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        bos.write("Hello bos".getBytes());
        bos.flush();
        bos.close();
    }
}
