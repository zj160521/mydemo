package com.demo.Instanceof;

/**
 * 从程序输出可以看出,instanceof进行类型检查规则是:你属于该类吗？或者你属于该类的派生类吗？
 * 而通过getClass获得类型信息采用==来进行检查是否相等的操作是严格的判断。不会存在继承方面的考虑；
 * @author zhouj
 *
 */
public class InstanceofTest {
	
    public static void testInstanceof(Object x){  
        System.out.println("x instanceof Parent:  "+(x instanceof Parent));  
        System.out.println("x instanceof Child:  "+(x instanceof Child));  
        System.out.println("x getClass Parent:  "+(x.getClass() == Parent.class));  
        System.out.println("x getClass Child:  "+(x.getClass() == Child.class));  
    }

    public static void main(String[] args) {  
        testInstanceof(new Parent());  
        System.out.println("---------------------------");  
        testInstanceof(new Child());  
    } 

}

class Parent {
	
}

class Child extends Parent {  
  
}
/* 
输出: 
x instanceof Parent:  true 
x instanceof Child:  false 
x getClass Parent:  true 
x getClass Child:  false 
--------------------------- 
x instanceof Parent:  true 
x instanceof Child:  true 
x getClass Parent:  false 
x getClass Child:  true 
*/  