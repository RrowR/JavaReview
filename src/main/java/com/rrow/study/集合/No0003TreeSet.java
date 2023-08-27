package com.rrow.study.集合;

import com.rrow.study.entity.ComparedObject;
import com.rrow.study.entity.ComparedObject2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author: Rrow
 * @date: 2023/8/27 23:22
 * Description: 比较TreeSet
 */
public class No0003TreeSet {

    /*
    * 内部比较器   实体类实现Comparable接口
    * */
    @Test
    public void test01() {
        TreeSet<ComparedObject> set = new TreeSet<>();
        set.add(new ComparedObject("aaa", "sss", 5));
        set.add(new ComparedObject("aaa", "sss", 4));
        set.add(new ComparedObject("aaa", "sss", 3));
        set.add(new ComparedObject("aaa", "sss", 2));
        for (ComparedObject comparedObject : set) {
            System.out.println("comparedObject = " + comparedObject);
        }

    }

    /*
     * 外部比较器   外部传入比较器的方法
     * */
    @Test
    public void test02() {
        ArrayList<ComparedObject2> list = new ArrayList<>();
        list.add(new ComparedObject2("aaa", "sss", 5));
        list.add(new ComparedObject2("aaa", "sss", 4));
        list.add(new ComparedObject2("aaa", "sss", 3));
        list.add(new ComparedObject2("aaa", "sss", 2));
        // 调用外部比较器的方法
        list.sort(Comparator.comparingInt(ComparedObject2::getAge));
        for (ComparedObject2 comparedObject2 : list) {
            System.out.println("comparedObject2 = " + comparedObject2);
        }
    }

}
