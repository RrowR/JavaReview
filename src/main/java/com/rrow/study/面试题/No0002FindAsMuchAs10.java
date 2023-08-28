package com.rrow.study.面试题;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Rrow
 * @date: 2023/8/28 22:34
 * Description:
 */
public class No0002FindAsMuchAs10 {
    public static void main(String[] args) {
        String filePath = "url_path_statistics.txt";
        int topN = 10;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Map<String, Integer> pathCountMap = new HashMap<>();
            // 字符流获取每一行数据
            while ((line = reader.readLine()) != null) {
                // 根据 : 符号进行分割
                String[] parts = line.split(":");
                // 长度分割位2个数组进行下一步操作
                if (parts.length == 2) {
                    String path = parts[0];
                    // 将访问次数从String转为int
                    int count = Integer.parseInt(parts[1]);
                    // 放到map里
                    pathCountMap.put(path, count);
                }
            }

            // 创建一个有限队列,根据Map的value进行排序
            PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                    Comparator.comparingInt(Map.Entry::getValue)
            );

            // 遍历map,将数据放到队列中
            for (Map.Entry<String, Integer> entry : pathCountMap.entrySet()) {
                // 放入队列,队列大小超过topN,则弹出队首最小元素,循环放入弹出,得到最大的10个Entry.value
                minHeap.offer(entry);
                if (minHeap.size() > topN) {
                    minHeap.poll(); // 维护堆的大小为topN
                }
            }

            // 输出前topN的路径和访问次数
            while (!minHeap.isEmpty()) {
                Map.Entry<String, Integer> entry = minHeap.poll();
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
