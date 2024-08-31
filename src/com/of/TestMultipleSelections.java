package com.of;

/**
 * 测试多重选择
 *
 * @author OldFriend
 */
public class TestMultipleSelections {
    public static void main(String[] args) {
        // 输出一些内容
        System.out.println("程序开始执行...");

        // 输出九九乘法表
        printMultiplicationTable();

        // 输出一些内容
        System.out.println("九九乘法表输出完毕...");

        // 计算并输出奇数和偶数的和
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sumEven += i; // 偶数
            } else {
                sumOdd += i; // 奇数
            }
        }
        System.out.println("1到10之间偶数的和为: " + sumEven);
        System.out.println("1到10之间奇数的和为: " + sumOdd);

        // 输出一些内容
        System.out.println("奇数和偶数的和计算完毕...");
        System.out.println("程序执行结束。");
    }

    // 打印九九乘法表的方法
    private static void printMultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            System.out.println(); // 换行
        }
    }
}
