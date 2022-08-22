package com.demo.object;

import java.util.Objects;

public class Person implements Cloneable {

    private String name;
    private Integer age;
    private Student student;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person per = (Person) obj;
        return Objects.equals(name, per.name);
    }

    //实现Cloneable的clone方法，将clone定义为public
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", student=" + student +
                '}';
    }
}
