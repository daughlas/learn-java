package com.geekbang.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodTest {
    @Test
    /**
     * 测试公有方法
     */
    public void demo1() throws Exception {
        Class c = Class.forName("com.geekbang.reflect.Person");

        Person p = (Person) c.newInstance();

        Method m = c.getMethod("eat");

        m.invoke(p);
    }

    @Test
    /**
     * 测试私有方法
     */
    public void demo2() throws Exception {
        Class c = Class.forName("com.geekbang.reflect.Person");

        Person p = (Person) c.newInstance();

        Method m = c.getDeclaredMethod("run");

        m.setAccessible(true);

        m.invoke(p);

    }

    @Test
    /**
     * 测试私有方法带参数
     */
    public void demo3() throws Exception {
        Class c = Class.forName("com.geekbang.reflect.Person");

        Person p = (Person) c.newInstance();

        Method m = c.getDeclaredMethod("hello", String.class);

        m.setAccessible(true);

        Object result = m.invoke(p, "吕嘉文");

        System.out.println(result);
    }
}
