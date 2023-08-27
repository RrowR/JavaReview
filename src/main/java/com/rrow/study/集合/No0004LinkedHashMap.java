package com.rrow.study.集合;

import com.rrow.study.entity.ComparedObject;
import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author: Rrow
 * @date: 2023/8/28 0:27
 * Description:
 */
public class No0004LinkedHashMap {
    /*
    * LinkedHashMap是有序的
    * */
    @Test
    public void test01() {
        LinkedHashMap<String, ComparedObject> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", new ComparedObject("aaa", "sss", 5));
        linkedHashMap.put("2", new ComparedObject("aaa", "sss", 4));
        linkedHashMap.put("3", new ComparedObject("aaa", "sss", 3));
        linkedHashMap.put("4", new ComparedObject("aaa", "sss", 2));
        for (String s : linkedHashMap.keySet()) {
            System.out.println("s = " + s);
        }

    }
}
