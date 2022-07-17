package com.demo.algorithms;


import java.util.Arrays;
import java.util.Comparator;

public class A8_Comparator {
    public static void main(String[] args) {
        Student[] list = {
                new Student.Builder().age(21).name("first").id(3).build(),
                new Student.Builder().age(20).name("sec").id(1).build(),
                new Student.Builder().age(20).name("third").id(2).build()
        };
        Arrays.sort(list, new IdAscendingComparator());
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

}

class Student {
    private int id;
    private String name;
    private int age;

    private Student(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.age = b.age;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "  name: " + this.name + "  age: " + this.age;
    }
}
