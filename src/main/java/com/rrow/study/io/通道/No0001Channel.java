package com.rrow.study.io.通道;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Rrow
 * @date: 2023/8/13 23:27
 * Description: FileChannel 演示一下读取文件数据
 */
public class No0001Channel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile reader = new RandomAccessFile("D:\\IDECodeProject\\IdeaSpace\\JavaReview\\.gitignore", "r");
        FileChannel channel = reader.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // channel将数据拷贝到buffer中(Read)
        channel.read(buffer);
    }
}
