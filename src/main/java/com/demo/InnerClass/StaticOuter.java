package com.demo.InnerClass;

/**
 * @Description:
 * @Author: zhouj
 * @Date: 2019/7/31 10:30
 */
public class StaticOuter {
    private static String msg = "static inner class";
    static class Inner {
        public void print() {
            System.out.println(msg);
        }
    }
}
