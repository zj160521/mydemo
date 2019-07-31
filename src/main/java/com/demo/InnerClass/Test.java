package com.demo.InnerClass;

/**
 * @Description:
 * @Author: zhouj
 * @Date: 2019/7/31 9:22
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("***********普通内部类***********");
        Outer01.Inner in = new Outer01().new Inner();// 内部类可以直接访问外部类的私有属性，所以在实例化内部类之前要实例化外部类
        in.fun();
        Outer01 out = new Outer01();
        out.fun();
        System.out.println("***********接口内部类***********");
        IOuter iOuter = new OuterImpl();
        IOuter.IMsg iMsg = new OuterImpl().new MsgImpl();
        iOuter.send(iMsg);
        System.out.println("***********抽象内部类***********");
        System.out.println("===========todo===========");
        System.out.println("***********内部类实现接口***********");
        IOuter.InOuterImpl inOuter = new IOuter.InOuterImpl();
        inOuter.send(new OuterImpl().new MsgImpl());
        System.out.println("***********static内部类class实现***********");
        StaticOuter.Inner inner = new StaticOuter.Inner();
        inner.print();
        System.out.println("***********static内部类interface实现***********");
        StaticIOuter staticIOuter = new StaticIImpl();
        staticIOuter.send(new DefaultMsg());


    }
}
