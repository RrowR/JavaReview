package com.rrow.study.io.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Rrow
 * @date: 2023/8/14 11:48
 * Description: 这里可以用telnet来进行测试  telnet ip port
 * 在示例中，我们创建了一个简单的服务器，监听8080端口，使用 Selector 处理连接、读取和写入事件。当接收到客户端的数据时，服务器将读取数据并将其打印到控制台，然后向客户端回复 "Hello, Client!"。
 */
public class No0002NioSelectorExample {
    public static void main(String[] args) {
        try {
            // 创建ServerSocketChannel对象
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));

            Selector selector = Selector.open();
            // 将 ServerSocketChannel 注册到 Selector 并监听 OP_ACCEPT 事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int readyChannels = selector.select();

                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // 处理连接事件
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);

                        // 将客户端通道注册到 Selector 并监听 OP_READ 事件
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        // 处理读事件
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = client.read(buffer);

                        if (bytesRead > 0) {
                            buffer.flip();
                            System.out.println("收到数据：" +new String(buffer.array(), 0, bytesRead));
                            // 将客户端通道注册到 Selector 并监听 OP_WRITE 事件
                            client.register(selector, SelectionKey.OP_WRITE);
                        } else if (bytesRead < 0) {
                            // 客户端断开连接
                            client.close();
                        }
                    } else if (key.isWritable()) {
                        // 处理写事件
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.wrap("Hello, Client!".getBytes());
                        client.write(buffer);

                        // 将客户端通道注册到 Selector 并监听 OP_READ 事件
                        client.register(selector, SelectionKey.OP_READ);
                    }

                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
