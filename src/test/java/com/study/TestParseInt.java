package com.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Rrow
 * @date: 2024/4/1 21:43
 * Description:
 */
public class TestParseInt {

    @Test
    public void test01() {
        String num = "12dwsadsa3";
        Integer.parseInt(num);
    }

    @Test
    public void test02() {
        String num = "1dsadsa23";
        Integer.valueOf(num);
    }

    @Test
    public void test03() {
        List<String> list = Arrays.asList("1", "2", "cc", "11", "a", "9", "55", "kk");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            try {
                System.out.println("Integer.parseInt(iterator.next()) = " + Integer.parseInt(iterator.next()));
            } catch (NumberFormatException e) {
            }
        }
    }

    @Test
    public void test04() {
        // String a = "a";
        // String z = "z";
        // System.out.println("a.getBytes() = " + a.getBytes());
        // System.out.println("z.getBytes() = " + z.getBytes());
        Character aa = 97;
        System.out.println(aa);
    }

    @Test
    public void test05() {
        List<String> list = Arrays.asList("1", "2", "cc", "11", "a", "9", "55", "kk");
        char c0 = '0', c9 = '9';
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            try {
                String next = iterator.next();
                for (int i = 0; i < next.length(); i++) {
                    char cur = next.charAt(i);
                    if(cur < c0 || cur > c9) {
                        throw new Exception();
                    }
                }
                System.out.println(next);
            } catch (Exception ignore) {
            }
        }
    }

    @Test
    public void testSpeed() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            test05();
        }
        long end = System.currentTimeMillis();
        System.out.println("end-start = " + (end - start));
    }

    @Test
    public void testSpeed2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            test03();
        }
        long end = System.currentTimeMillis();
        System.out.println("end-start = " + (end - start));
    }
}
