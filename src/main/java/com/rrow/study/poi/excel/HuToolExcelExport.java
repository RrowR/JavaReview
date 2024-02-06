package com.rrow.study.poi.excel;

import java.text.DecimalFormat;

/**
 * @author: Rrow
 * @date: 2024/1/3 15:09
 * Description:
 */
public class HuToolExcelExport {
    public static void main(String[] args) {
        String s = formatWithCommas("1231.99");
        System.out.println("s = " + s);
    }

    private static String formatWithCommas(String numberStr) {
        // 将字符串转换为长整数
        Double number = Double.parseDouble(numberStr);

        // 创建DecimalFormat对象并设置千分符
        DecimalFormat formatter = new DecimalFormat("#,###.####");

        // 使用format方法格式化数字字符串
        return formatter.format(number);
    }
}
