package com.rrow.study.io.selector;

import java.nio.channels.SelectionKey;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Rrow
 * @date: 2023/8/14 11:41
 * Description:
 */
public class No0001SelectionKey {
    public static void main(String[] args) {
        /*Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
        while (keyIterator.hasNext()) {
            SelectionKey key = keyIterator.next();
            if (key != null) {
                if (key.isAcceptable()) {
                    // ServerSocketChannel 接收了一个新连接
                } else if (key.isConnectable()) {
                    // 表示一个新连接建立
                } else if (key.isReadable()) {
                    // Channel 有准备好的数据，可以读取
                } else if (key.isWritable()) {
                    // Channel 有空闲的 Buffer，可以写入数据
                }
            }
            keyIterator.remove();
        }*/

    }
}
