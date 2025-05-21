package com.study;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * N个国家参加奥运会,请按照要求在控制台输出各个国家每天获取的奖牌数,并计算总奖牌数,输出到最后-列
 * 输出示例:2020-01-23 2020-01-24 2020-01-252020-01-26 总奖牌数
 * A 2 3 .... 20B40... 15
 * 要求:
 * 1.日期从小到大输出
 * 2.如果国家当日没有获得奖牌,则是0个奖牌
 * 3. 数据格式为 国家名;日期:奖牌数,可用;进行切割
 * 可能用到的API:
 * 1.String转Timestamp:
 * str=“2020-01-25 12:13:26"
 * Timestamp.valueOf(str);
 * 2.Timestamp转String:
 * new SimpleDateFormat("yyyy-MM-
 * dd").format(time);
 */
public class ShowMeBug {
    public static void main(String[] args) {
        List<String> list = getList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Set<String> dates = new HashSet<>();
        Set<String> countries = new HashSet<>();
        Integer totalJiangpai = 0;

        for (String item : list) {
            String[] parts = item.split(";");
            String date = parts[1].split(" ")[0];
            dates.add(date);
            countries.add(parts[0]);
            totalJiangpai += Integer.parseInt(parts[2]);
        }

        List<String> sortedDates = dates.stream()
                .sorted()
                .collect(Collectors.toList());

        Map<String, Map<String, Integer>> countryMedalMap = new TreeMap<>();

        for (String country : countries) {
            Map<String, Integer> dateMedalMap = new LinkedHashMap<>();
            for (String date : sortedDates) {
                dateMedalMap.put(date, 0);
            }
            countryMedalMap.put(country, dateMedalMap);
        }

        for (String item : list) {
            String[] parts = item.split(";");
            String country = parts[0];
            String date = parts[1].split(" ")[0];
            int medals = Integer.parseInt(parts[2]);

            Map<String, Integer> dateMedalMap = countryMedalMap.get(country);
            dateMedalMap.put(date, dateMedalMap.get(date) + medals);
        }

        Map<String, Integer> totalMedals = new HashMap<>();
        for (String country : countryMedalMap.keySet()) {
            int total = countryMedalMap.get(country).values().stream()
                    .mapToInt(Integer::intValue).sum();
            totalMedals.put(country, total);
        }

        for (String date : sortedDates) {
            System.out.print(date + " ");
        }
        System.out.println(totalJiangpai);

        for (String country : countryMedalMap.keySet()) {
            System.out.print(country + " ");
            Map<String, Integer> dateMedalMap = countryMedalMap.get(country);
            for (String date : sortedDates) {
                System.out.print(dateMedalMap.get(date) + " ");
            }
            System.out.println(totalMedals.get(country));
        }
    }

    static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("CHN;2022-01-28 00:00:00;5");
        list.add("RUS;2022-01-30 00:00:00;2");
        list.add("CHN;2022-01-31 00:00:00;3");
        list.add("USA;2022-01-31 00:00:00;5");
        list.add("IND;2022-01-28 00:00:00;4");
        list.add("RUS;2022-01-28 00:00:00;2");
        list.add("CHN;2022-01-29 00:00:00;7");
        list.add("IND;2022-01-30 00:00:00;4");
        list.add("KR;2022-01-31 00:00:00;5");
        list.add("CHN;2022-02-01 00:00:00;5");
        list.add("USA;2022-01-28 00:00:00;1");
        list.add("KR;2022-01-28 00:00:00;3");
        list.add("JP;2022-01-28 00:00:00;2");
        list.add("USA;2022-02-01 00:00:00;3");
        list.add("KR;2022-02-01 00:00:00;5");
        list.add("JP;2022-02-01 00:00:00;1");
        list.add("IND;2022-02-01 00:00:00;3");
        list.add("RUS;2022-02-01 00:00:00;2");
        list.add("KR;2022-01-29 00:00:00;2");
        list.add("RUS;2022-01-29 00:00:00;2");
        list.add("CHN;2022-01-30 00:00:00;1");
        list.add("USA;2022-01-30 00:00:00;3");
        list.add("KR;2022-01-30 00:00:00;5");
        list.add("JP;2022-01-30 00:00:00;5");
        list.add("IND;2022-02-02 00:00:00;4");
        list.add("RUS;2022-02-02 00:00:00;5");
        return list;
    }
}