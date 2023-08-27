package com.rrow.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComparedObject implements Comparable<ComparedObject> {   // 注意这里是Comparable
    private String name;
    private String hobby;
    private int age;

    @Override
    public int compareTo(ComparedObject o) {
        return this.getAge() - o.getAge();
    }
}