package com.demo.object;

import java.util.*;

public class ObjectTest {


    public static void main(String[] args) throws CloneNotSupportedException {
        // 只重写equals方法，不重写hashcode方法会导致hash集合里认为对象不等
        System.out.println("==========equals与hashcode==========");
        Person equ = new Person("jk", 20);
        Person equ2 = new Person("jk", 20);
        System.out.println("对象是否相等：" + equ.equals(equ2));
        HashSet hashSet = new HashSet();
        hashSet.add(equ);
        hashSet.add(equ2);
        // 相等的两个对象放在hash集合中却认为是两个不同对象
        System.out.println(String.format("hash集合中对象个数:%s,%s", hashSet.size(), "  （个数为2说明hashset认为他们是两个不同的对象）"));
        System.out.println();

        // clone:浅拷贝与深拷贝
        System.out.println("==========浅拷贝与深拷贝==========");
        Person person = new Person("jk", 20);
        Student student = new Student("jk", "male");
        person.setStudent(student);
        Person clone = person.clone();
        clone.setName("vv");
        clone.setAge(30);
        clone.getStudent().setName("VV");
        clone.getStudent().setSex("female");
        System.out.println(person);
        System.out.println(clone);
        System.out.println("字符串和基本数据类型都是复制拷贝（值传递），引用数据类型是引用传递（浅拷贝）和复制拷贝（深拷贝）");
        System.out.println();

        // 值传递、引用传递
        System.out.println("==========值传递==========");
        String name = "La";
        Person value = new Person("jk", 20);
        changeName(name, value);
        System.out.println(name);
        System.out.println(value);
        System.out.println("java中实参与形参之间是值传递，没有引用传递，只是对象类型的参数是值传递中特殊的共享对象传递，不是复制的对象而是复制了对象引用传给形参");
        System.out.println();
    }

    private static void changeName(String name, Person person){
        name = "pp";
        person.setAge(11);
        person.setName("mm");
    }


}

