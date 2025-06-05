package com.rrow.study.集合;

import java.util.HashMap;

/**
 * @author: Rrow
 * @date: 2023/8/25 16:53
 * Description:
 * 在第一次put元素的时候,其实是调用的putVal方法,如果长度为0或者为null的时候,则会进行一次扩容
 * 当长度为0的时候,自动分配一个默认长度为16
 * static final int *DEFAULT_INITIAL_CAPACITY* = 1 << 4; // aka 16
 * 如果链表的长度大于等于8,并且数组长度大于64,链表将转为红黑树
 * ***当数组长度小于 MIN_TREEIFY_CAPACITY = 64 的时候,即使链表长度大于8,都会选择先扩容
 * 只有当数组长度达到64,链表长度再大于8,才会变成红黑树
 */
public class No0002HashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        String a = "aaa";
        System.out.println("a.hashCode() = " + a.hashCode());
    }
}
