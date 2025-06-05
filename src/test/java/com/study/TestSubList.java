package com.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rrow
 * @date: 2023/10/8 14:07
 * Description:
 */
public class TestSubList {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list2 = list.subList(0, 1);
        System.out.println(list2);
    }

    @Test
    public void test02() {
        ArrayList<Object> list = new ArrayList<>();
        list.forEach(System.out::println);
    }

}
