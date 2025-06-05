package com.study;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Rrow
 * @date: 2024/1/22 0:24
 * Description:
 */
public class Test获取工作日的前一天 {
    public static void main(String[] args) {
        // 获取前端传递过来的开始时间字符串
        String startTimeString = "2024-01-19";
        // 将字符串解析为日期对象
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime;
        try {
            startTime = dateFormat.parse(startTimeString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // 使用Calendar类进行日期操作
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        // 减去一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        // 如果结果是周六或周日，继续减去一天，直到不是周六或周日为止
        while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 将结果格式化为字符串
        String result = dateFormat.format(calendar.getTime());
        System.out.println(result);
    }
}
