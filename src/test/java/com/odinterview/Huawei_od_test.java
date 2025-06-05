package com.odinterview;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: Rrow
 * @date: 2024/9/5 14:28
 * Description:
 */
public class Huawei_od_test {

    @Test
    public void test01() {
        int arr[] = {2, 1, 5, 7, 4};
        // 使用冒泡排序排序上列内容
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        }
        System.out.println(Arrays.toString(arr));
        
    }
}
