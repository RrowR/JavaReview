package com.rrow.study.io.字符流;

import org.junit.Test;

import java.io.*;

/**
 * @author: Rrow
 * @date: 2023/8/12 22:53
 * Description: 用buffer和不用buffer流的拷贝速度相差几百倍
 */
public class No0003StreamToCopyWithBufferAndNoBuffer {
    @Test
    public void useBuffer() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1.mp4"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1-bak.mp4"))) {
            int content;
            while ((content = bis.read()) != -1) {
                bos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    @Test
    public void noBuffer() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("1.mp4");
             FileOutputStream fos = new FileOutputStream("2-bak.mp4")) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }
}
