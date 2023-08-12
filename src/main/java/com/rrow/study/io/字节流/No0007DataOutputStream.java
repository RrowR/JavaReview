package com.rrow.study.io.字节流;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/8/12 10:44
 * Description: DataOutputStream 用于写入指定类型数据，不能单独使用，必须结合其它流，比如 FileOutputStream
 */
public class No0007DataOutputStream {
    public static void main(String[] args) throws IOException {
        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream("dos.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        // 输出任意数据类型
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeByte(1);
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
