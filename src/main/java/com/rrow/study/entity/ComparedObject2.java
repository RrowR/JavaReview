package com.rrow.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;


/*
* 没有比较器,可以通过外部比较器的方法进行属性比较
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComparedObject2 {
    private String name;
    private String hobby;
    private int age;
}