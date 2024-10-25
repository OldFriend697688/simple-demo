package com.of;

/**
 * 测试热插拔
 *
 * @author OldFriend
 */
public class TestHotSwap {
    public static void main(String[] args) {
        TestUtils.download2("11");
        System.out.println("TestHotSwap.main");
    }

    public static void testMethod2(int age) {
        System.out.println("TestHotSwap.testMethod2");
        System.out.println("TestHotSwap.testMethod2222");
    }
}


class TestUtils {
    public static void download2(String name) {
        System.out.println("TestUtils.download");
        System.out.println("name:" + name);
    }
}