package com.geekbang.reflect;


import org.junit.Test;

public class ClassTest {
    @Test
    /**
     * 获取 Class 对象
     * 1 类名.class
     * 2 对象.getClass()
     * 3 Class.forName()
     */
    public void demo1() throws ClassNotFoundException {
        // 1
        Class clazz1 = Person.class;

        // 2
        Person person = new Person("吕嘉文", "男");
        Class clazz2 = person.getClass();

        // 3
        Class clazz3 = Class.forName("com.geekbang.reflect.Person");
    }
}
