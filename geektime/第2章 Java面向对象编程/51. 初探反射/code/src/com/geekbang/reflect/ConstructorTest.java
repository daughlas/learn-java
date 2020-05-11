package com.geekbang.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConstructorTest {
    @Test
    /**
     * 获得无参数的构造方法
     */
    public void demo1() throws Exception {
        Class clazz = Class.forName("com.geekbang.reflect.Person");
        Constructor c =  clazz.getConstructor();
        Person p = (Person) c.newInstance(); // 默认返回 Object，这句话相当于 new 了一个 Person
        p.eat();
    }

    @Test
    /**
     * 获得有参数的构造方法
     */
    public void demo2() throws Exception {
        Class clazz = Class.forName("com.geekbang.reflect.Person");
        Constructor c =  clazz.getConstructor(String.class, String.class);
        Person p = (Person) c.newInstance("吕嘉文", "男"); // 默认返回 Object，这句话相当于 new 了一个 Person
        System.out.println(p);
    }
}
