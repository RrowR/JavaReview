package com.rrow.study.io.字节流;

import com.rrow.study.entity.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: Rrow
 * @date: 2023/8/12 10:47
 * Description: 用于从输入流中读取 Java 对象（ObjectInputStream,反序列化），ObjectOutputStream将对象写入到输出流(ObjectOutputStream，序列化)。
 */
public class No0004_2ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("userObject.txt"));
        User user = new User("ddd", "play games");
        output.writeObject(user);

    }
}
