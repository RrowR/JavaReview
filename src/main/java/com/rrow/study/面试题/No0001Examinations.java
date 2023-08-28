package com.rrow.study.面试题;

import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2023/8/28 22:02
 * Description:
 * 如何把⼗进制转换为⼆进制，请分别⽤递归，循环和位操作来实现；
 */
public class No0001Examinations {

    /**
     * 十进制除2取模,一直递归自己直到商为0,然后把余数倒过来字符串相加
     */
    @Test
    public void examRecursive() {
        int d = 1024;
        String b = d2B(d);
        System.out.println("原先的十进制为" + d + " 转换为二进制是: " + b);
    }

    public String d2B(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else {
            int last = n % 2;
            String prev = d2B(n / 2);
            return prev + last;
        }
    }

    /**
     * 将十进制除2取余作为二进制数的每一位,然后倒过来相加
     */
    @Test
    public void examCycle() {
        int decimalNumber = 1024;
        String binary = decimalToBinaryIterative(decimalNumber);
        System.out.println("原先的十进制为 " + decimalNumber + " 转换为二进制是: " + binary);
    }

    public String decimalToBinaryIterative(int n) {
        StringBuilder binary = new StringBuilder();
        if (n == 0) {
            binary.append("0");
        }
        while (n > 0) {
            int remainder = n % 2;
            // 余数直接添加到最左边
            binary.insert(0,remainder);
            // 除2取商,作为下一轮循环的被除数
            n = n / 2;
        }
        return binary.toString();
    }

    /**
     * 二进制位右移n位,代表除2^n取商,然后与1做与运算,代表取余数
     */
    @Test
    public void examBit() {
        int decimalNumber = 1024;
        String binary = decimalToBinaryBitwise(decimalNumber);
        System.out.println("十进制数 " + decimalNumber + " 转换为二进制是: " + binary);
    }

    public String decimalToBinaryBitwise(int n) {
        StringBuilder binary = new StringBuilder();
        int numberOfBits = 32; // 假设是32位整数
        for (int i = 0; i < numberOfBits; i++) {
            int bit = (n >> i) & 1;
            binary.insert(0,bit);
        }
        return binary.toString();
    }


}
