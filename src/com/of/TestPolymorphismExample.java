package com.of;

import java.util.Objects;

/**
 * 测试面向对象编程中的多态特性
 *
 * @author OldFriend
 */
public class TestPolymorphismExample {
    public static void main(String[] args) {
        /*
         * 父类的引用类型变量指向子类的对象，实际的对象类型将由 JVM 在运行时进行动态绑定，
         * 这也是 Java 中向上转型的默认行为，它不需要进行强制类型转换操作.
         * */
        Animal cat = new Cat(); // 实际的类型是 Cat
        Animal dog = new Dog(); // 实际的类型是 Dog

        /*
         * 如下两行代码看似调用的均是 Animal 类中的 eat 方法，
         * 但实际上它们所调用的是 Dog 类中的 eat 方法以及 Cat 类中的 eat 方法，
         * 这是因为 JVM 会在运行时通过动态绑定技术来明确真正被调用的方法到底来自于何处.
         * */
        dog.eat();
        cat.eat();

        /*
         * 如下两行代码实际上调用的是 Animal 类中的 sleep 方法，
         * 这是因为 Dog 和 Cat 类中并未重写 Animal 类中的 sleep 方法，
         * 如此一来 JVM 将会自动找到并调用 Animal 类中的 sleep 方法.
         * */
        dog.sleep();
        cat.sleep();

        /*
         * 如下两行代码通过使用向下转型的方式调用子类中特有的目标方法，
         * 向下转型是指将父类的引用类型变量转换为子类的引用类型变量，
         * 这一步骤和向上转型有所不同，它必须要通过强制类型转换操作.
         * */
        if (dog instanceof Dog) {
            ((Dog) dog).run();
        }
        if (cat instanceof Cat) {
            ((Cat) cat).jump();
        }

        System.out.println(cat.getType());
        System.out.println(dog.getType());
        System.out.println(dog.getName());

     

    }

    /**
     * 动物类，它是所有动物的父类
     *
     * @author OldFriend
     */
    static class Animal {
        private String name;
        private String type = "宠物";
        private int age;
        private String gender;

        public Animal() {
        }

        public Animal(String name, String type, int age, String gender) {
            this.name = name;
            this.type = type;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        /**
         * 动物的通用吃饭方法
         */
        public void eat() {
            System.out.println("Animal.eat");
        }

        /**
         * 动物通用的休息方法
         */
        public void sleep() {
            System.out.println("Animal.sleep");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            if (age != animal.age) return false;
            if (!Objects.equals(name, animal.name)) return false;
            if (!Objects.equals(type, animal.type)) return false;
            return Objects.equals(gender, animal.gender);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            result = 31 * result + age;
            result = 31 * result + (gender != null ? gender.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Animal{" + "name='" + name + '\'' + ", type='" + type + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
        }
    }

    /**
     * 狗类，它是动物类的子类
     *
     * @author OldFriend
     */
    static class Dog extends Animal {
        private String name = "狗狗";

        public Dog() {
        }

        public Dog(String name, String type, int age, String gender) {
            super(name, type, age, gender);
        }

        /**
         * 属于狗这种生物特有的吃饭行为的实现
         */
        @Override
        public void eat() {
            System.out.println("狗会选择吃狗粮!!!");
        }

        /**
         * 奔跑
         */
        public void run() {
            System.out.println("狗在奔跑!!");
        }
    }

    /**
     * 猫咪类，它是动物类的子类
     *
     * @author OldFriend
     */
    static class Cat extends Animal {
        public Cat() {
        }

        public Cat(String name, String type, int age, String gender) {
            super(name, type, age, gender);
        }

        @Override
        public void eat() {
            System.out.println("猫咪会选择吃鱼!!!");
        }

        public void jump() {
            System.out.println("猫咪会跳起来!!!");
        }
    }
}
