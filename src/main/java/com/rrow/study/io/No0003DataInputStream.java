package com.rrow.study.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/9 18:33
 * Description:
 */
public class No0003DataInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            //必须将fileInputStream作为构造参数才能使用
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            //可以读取任意具体的类型数据
            // System.out.println("dataInputStream.readBoolean() = " + dataInputStream.readBoolean());
            // System.out.println("dataInputStream.readInt() = " + dataInputStream.readInt());
            int available = dataInputStream.available();
            System.out.println("available = " + available);
            // 长度需要大于 18533
            String dataInputStreamData = dataInputStream.readUTF();
            System.out.println("dataInputStreamData = " + dataInputStreamData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
