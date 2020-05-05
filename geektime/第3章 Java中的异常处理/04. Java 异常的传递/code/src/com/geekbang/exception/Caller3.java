package com.geekbang.exception;

public class Caller3 {
    public void callThrowRTException() {
        System.out.println("Caller3.callThrowRTException开始");
        Object n = null;
        n.toString();
        System.out.println("Caller3.callThrowRTException结束");
    }

    public void callThrowException() throws ClassNotFoundException {
        System.out.println("Caller3.callThrowException开始");
        try {
            Class.forName("com.neverland.Rabbit");
        } catch (ClassNotFoundException ex) {
            System.out.println("got exception in Caller1: "+ex.getMessage());
        }
        System.out.println("Caller3.callThrowException结束");
    }
}
