package com.geekbang.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    /**
     * 公有属性，有和没有差不多
     */
    public void demo1() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("com.geekbang.reflect.Person");

        Field nameField = c.getField("name");

        Person p = (Person) c.newInstance();

        nameField.set(p, "hello world");

        System.out.println(nameField.get(p));
    }

    @Test
    /**
     * 私有属性
     * 没有 get 和 set 方法 的私有属性，这个可以操作
     */
    public void demo2() throws Exception {
        Class c = Class.forName("com.geekbang.reflect.Person");

        // 获得私有属性
        Field field = c.getDeclaredField("sex");

        Person p = (Person) c.newInstance();

        field.setAccessible(true);

        field.set(p, "123");

        System.out.println(field.get(p));

    }
}
