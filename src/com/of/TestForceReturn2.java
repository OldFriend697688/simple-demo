package com.of;

/**
 * 测试强制返回(Force Return)
 *
 * @author OldFriend
 */
public class TestForceReturn2 {
    public static void main(String[] args) {
        writerData();
    }

    public static void writerData() {
        System.out.println("TestForceReturn2.writerData");
        // 当执行强制返回操作后，showMessage 函数将不会被调用
        showMessage();
    }

    public static void showMessage() {
        System.out.println("TestForceReturn2.showMessage");
    }
}
