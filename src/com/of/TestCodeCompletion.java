package com.of;

import java.util.Objects;

/**
 * 测试禁用代码自动补全
 *
 * @author OldFriend
 */
public class TestCodeCompletion {
    public Dog testInstance(Dog dog) {
        return new Dog();
    }

    abstract class Animal {
        public Animal() {
        }

        public abstract void eat();

        public abstract void play();
    }

    class Dog extends Animal {
        public Dog() {
        }

        @Override
        public void eat() {
            System.out.println("Dog.eat");
        }

        @Override
        public void play() {
            System.out.println("Dog.play");
        }
    }

    class Cat {
        private String name;
        private String hobby;
        private int age;

        public Cat() {
        }

        public Cat(String name, String hobby, int age) {
            this.name = name;
            this.hobby = hobby;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int add(int a, int b) {
            return a + b;
        }

        public int add(int a, int b, int c) {
            return a + b + c;
        }

        public int add(int a, int b, int c, int d) {
            return a + b + c + d;
        }

        @Override
        public String toString() {
            return "Cat{" + "name='" + name + '\'' + ", hobby='" + hobby + '\'' + ", age=" + age + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return age == cat.age && Objects.equals(name, cat.name) && Objects.equals(hobby, cat.hobby);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, hobby, age);
        }
    }
}
