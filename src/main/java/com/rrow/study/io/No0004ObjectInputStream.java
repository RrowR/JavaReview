package com.rrow.study.io;

import com.rrow.study.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: Rrow
 * @date: 2023/8/9 19:17
 * Description:
 */
public class No0004ObjectInputStream {
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.data"));
            User user = (User) input.readObject();
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
