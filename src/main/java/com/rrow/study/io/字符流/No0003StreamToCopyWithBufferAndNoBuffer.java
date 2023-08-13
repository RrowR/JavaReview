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

    /**
     * 104 ms
     */
    @Test
    public void use_array_to_copy_mp4_with_buffer() {
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1.mp4"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1-bak.mp4"))) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    /**
     * 151 ms
     */
    @Test
    public void use_array_to_copy_mp4_with_fileOutPutStream_noBuffer() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("1.mp4");
             FileOutputStream fos = new FileOutputStream("1-bak.mp4")) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }
}
