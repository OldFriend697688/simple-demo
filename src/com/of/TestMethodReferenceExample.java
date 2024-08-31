package com.of;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 测试 JDK8 中的新增特性 —— 方法引用
 * <p>
 * 方法引用是 JDK8 中的新增特性之一，它是一种特殊语法，通过这种语法可以将方法作为参数传递给另一个方法。
 * 方法引用可以用于简化 Lambda 表达式，目前主要有四种方法引用形式，具体语法如下：
 * <p>
 * 1. 静态方法引用
 * <pre>
 * --> 语法：类名::静态方法名;
 * --> 示例：Arrays::sort、Integer::parseInt
 * </pre>
 * 2. 构造方法引用
 * <pre>
 * --> 语法：类名::new
 * --> 示例：ArrayList::new、User::new
 * </pre>
 * 3. 特定对象的实例方法引用
 * <pre>
 * --> 语法：实例对象名::实例方法名
 * --> 示例：string::toString
 * </pre>
 * 4. 特定类型非特定对象的实例方法引用
 * <pre>
 * --> 语法：类名::实例方法名
 * --> 示例：String::length
 * </pre>
 *
 * @author OldFriend
 */
public class TestMethodReferenceExample {
    public static void main(String[] args) {
        // 使用特定类型非特定对象的实例方法引用
        Integer[] integers = {1, 2, 4, 7, 0, 3, 22, 11, 88, 1, 2};
        Arrays.sort(integers, Integer::compareTo);
        System.out.println(Arrays.toString(integers));

        // 使用特定对象的实例方法引用
        User user = new User("张飞", 19, 20000);
        Supplier<String> name = user::getName;
        System.out.println(name.get());

        // 使用静态方法引用
        List<Integer> integerList = Arrays.asList("1", "3", "2", "5", "0")
                .stream()
                .map(Integer::parseInt)
                .filter(x -> x > 3)
                .collect(Collectors.toList());
        System.out.println(integerList);

        // 使用构造方法引用
        Supplier<User> user1 = User::new;
        System.out.println(user1.get());
        BiFunction<String, Integer, User> binFunction = User::new;
        User user2 = binFunction.apply("刘备", 19);
        System.out.println(user2.getName());
        UserFactory userFactory = User::new;
        User user3 = userFactory.create("张飞", 19, 3000);
        System.out.println(user3);
        BiFunction<String, Integer, User> user4 = (p1, p2) -> new User(p1, p2);
        System.out.println(user4.apply("赵云", 10));
    }

    @FunctionalInterface
    interface UserFactory {
        User create(String name, int age, double salary);
    }

    static class User {
        private String name;
        private int age;
        private double salary;

        {
            if (this.age <= 0 || this.age >= 120) this.age = 18;
            if (this.name == null) this.name = "默认用户名";
        }

        public User() {
        }


        public User(String name, int age, double salary) {
            this.age = age;
            this.name = name;
            this.salary = salary;
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }


        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            if (name.length() >= 16 || name == "") this.name = "默认用户名";
            else this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            if (age <= 0 || age >= 120) this.age = 18;
            else this.age = age;
        }

        public double getSalary() {
            return this.salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void greet(String greeting) {
            System.out.println(greeting + ", " + this.name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}

