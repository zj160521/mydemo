package com.demo.generic;

/**
 * @Author: zhouj
 * @Date: 2019/5/20 14:44
 */
public class GenericTest {
    public static void main(String[] args) {
        Generic<TClass> generic =  new Generic();
        TClass tClass = generic.getL(new TClass());
        System.out.println(tClass.value);
    }
}

class TClass{
    String value = "valueTest";
}
