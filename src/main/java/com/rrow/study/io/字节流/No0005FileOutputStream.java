package com.rrow.study.io.字节流;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/12 9:16
 * Description: FileOutputStream 用于写入诸如图像数据之类的原始字节的流
 */
public class No0005FileOutputStream {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("output.txt")) {
            byte[] array = "JavaGuide".getBytes();
            output.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
