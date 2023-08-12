package com.rrow.study.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: Rrow
 * @date: 2023/8/9 19:19
 * Description:
 */
public class User implements Serializable {
    private String name;
    private String info;

    public User(String name, String info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(info, user.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
