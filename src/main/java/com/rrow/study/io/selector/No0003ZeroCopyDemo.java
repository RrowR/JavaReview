package com.rrow.study.io.selector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Rrow
 * @date: 2023/8/14 12:11
 * Description: 伪代码,可以参考下列地址  https://www.cnblogs.com/robothy/p/14235598.html
 */
public class No0003ZeroCopyDemo {
    public static void main(String[] args) {

    }

    private void loadFileIntoMemory(File xmlFile) throws IOException {
/*
        FileInputStream fis = new FileInputStream(xmlFile);
        // 创建 FileChannel 对象
        FileChannel fc = fis.getChannel();
        // FileChannle.map() 将文件映射到直接内存并返回 MappedByteBuffer 对象
        MappedByteBuffer mmb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
        xmlFileBuffer = new byte[(int)fc.size()];
        mmb.get(xmlFileBuffer);
        fis.close();
*/
    }
}
