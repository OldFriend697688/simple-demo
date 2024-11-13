package com.of;

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
}
