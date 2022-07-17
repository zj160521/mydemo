package com.demo.innerClass;

/**
 * @Description: 内部类的优势：轻松的访问外部类（不需要实例化对象）的私有属性，反之外部类也可以（需要实例化内部类对象）
 * @Author: zhouj
 * @Date: 2019/7/31 9:20
 */
public class Outer01 {
    private String name = "outer class";
    public void fun() {
        String mcn = "method msg";
        Inner in = new Inner();
        System.out.println(in.iName);
        class methodInner{ // 方法中的内部类在jdk1.8可以访问方法的局部变量和参数
            public void print() {
                System.out.println(mcn);
            }
        }
    }
    class Inner {
        private String iName = "inner class";
        public void fun() {
            System.out.println(name);
        }
    }
}
