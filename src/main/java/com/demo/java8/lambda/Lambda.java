package com.demo.java8.lambda;

/**
 * jdk1.8出现lambda表达式
 * lambda表达式可以看成特殊的匿名内部类
 * lambda表达式针对于只有一个方法的借口（函数式接口），一般在接口上加注释@FunctionalInterface
 * （）形参列表
 *  -> 连接符
 *  {} 方法体,若只有一行代码方法体也可以省略
 */
public class Lambda {
    public static void main(String[] args) {
        LambdaInterface li = new LambdaInterface() {
            @Override
            public void test() {
                System.out.println("匿名内部类方法1");
            }
            @Override
            public String test2() {
                return "匿名内部类方法2";
            }
        };
        li.test();
        System.out.println(li.test2());

//        LambdaInterface1 li1 = () -> {
//            System.out.println("lambda表达式");
//        };
        LambdaInterface1 li1 = (str) -> System.out.println("lambda表达式" + str);
        li1.test("asdf");
    }
}
