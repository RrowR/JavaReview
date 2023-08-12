package com.rrow.study.io.字符流;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author: Rrow
 * @date: 2023/8/12 22:40
 * Description:
 */
public class No0002OutputStreamWriter {
    public static void main(String[] args) {
        try (Writer output = new FileWriter("writer.txt")) {
            output.write("您好,我是Rrow favorite is nachoneko");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
