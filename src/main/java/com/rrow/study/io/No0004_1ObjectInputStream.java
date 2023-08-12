package com.rrow.study.io;

import com.rrow.study.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: Rrow
 * @date: 2023/8/9 19:17
 * Description: 用于从输入流中读取 Java 对象（ObjectInputStream,反序列化），ObjectOutputStream将对象写入到输出流(ObjectOutputStream，序列化)。
 */
public class No0004_1ObjectInputStream {
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("userObject.txt"));
            User user = (User) input.readObject();
            System.out.println("user = " + user);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
