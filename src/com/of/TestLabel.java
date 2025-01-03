package com.of;

/**
 * 测试调试应用程序时为变量添加标签
 *
 * @author OldFriend
 */
public class TestLabel {
    public static void main(String[] args) {
        User[] users = new User[]{
                new User("赵云", 19, 1),
                new User("刘备", 19, 1),
                new User("关羽", 19, 1),
                new User("廖化", 19, 1)
        };
        work();
    }

    public static void work() {
        String[] names = new String[]{"赵云", "关羽", "张飞","刘备"};
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static int test(int a,int b, int c,int d, int e) {
        return a + b + c + d + e;
    }

    static class User {
        private String name;
        private int age;
        private int gender;

        public User() {
        }

        public User(String name, int age, int gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}
