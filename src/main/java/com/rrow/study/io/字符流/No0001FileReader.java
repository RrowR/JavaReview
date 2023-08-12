package com.rrow.study.io.字符流;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/12 22:31
 * Description:
 */
public class No0001FileReader {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("input.txt");) {
            int content;
            long skip = fileReader.skip(3);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
