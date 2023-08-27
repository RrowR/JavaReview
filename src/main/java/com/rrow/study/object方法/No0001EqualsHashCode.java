package com.rrow.study.object方法;

import org.junit.Test;

import java.util.Objects;

/**
 * @author: Rrow
 * @date: 2023/8/27 23:38
 * Description:
 * 重写equals的目的是因为需要比较对象的属性地址是否相等
 * 重写hashcode方法的目的是因为对象属性的hash值默认是属性地址的hash值,我们需要比较的是对象成员变量值的hash值,而不是对象成员属性的地址hash值
 *
 */
public class No0001EqualsHashCode {
    @Test
    public void test01() {
        No0001Object object = new No0001Object("小花");
        No0001Object object2 = new No0001Object("小花");
        System.out.println("object.equals(object2) = " + object.equals(object2));
        System.out.println("object.hashCode() = " + object.hashCode());
        System.out.println("object2.hashCode() = " + object2.hashCode());
    }

    private class No0001Object {
        private String name;

        public No0001Object() {
        }

        public No0001Object(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // @Override
        // public boolean equals(Object o) {
        //     if (this == o) return true;
        //     if (o == null || getClass() != o.getClass()) return false;
        //     No0001Object that = (No0001Object) o;
        //     return Objects.equals(name, that.name);
        // }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}
