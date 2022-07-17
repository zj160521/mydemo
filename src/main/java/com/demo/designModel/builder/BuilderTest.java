package com.demo.designModel.builder;

public class BuilderTest {

	public static void main(String[] args) {
        //  建造者模式:在代码中反复创建一个类的类对象并赋值的时候，采用建造者模式，可以让coder不必关心具体的类对象赋值
        //	如下我们在创建男人和女人的时候不必知道男人和女人长什么样子就进行创建
        //	避免出现一直new person 然后用set进行赋值，出现重复代码的情况
		 BuilderDirector bd = new BuilderDirector();  
         Person womanPerson = bd.constructPerson(new BuildMan());  
         Person manPerson = bd.constructPerson(new BuildWoman());
         System.out.println(womanPerson.getBody());
         System.out.println(manPerson.getBody());
         
         //建造者模式创建对象
         //Java Builder模式主要是用一个内部类去实例化一个对象，避免一个类出现过多构造函数，而且构造函数如果出现默认参数的话，很容易出错
         //public Person(String name)
         //public Person(String name, int age)
         //public Person(String name, int age, boolean sex)
         User build = new User.UserBuilder("z", "hao").address("cd").build();
         System.out.println(build.toString());
         build.setAddress("成都");
         System.out.println(build.toString());
	}
}