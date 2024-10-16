package com.of;

/**
 * 测试非挂起断点（Non-suspending breakpoints）
 * <p>
 * 使用非挂起断点可以在确保程序不暂停的情况下，对某一行代码进行评估。
 * <p>
 * 要创建这样的断点，只需要选中目标代码行前的间距图标并按  Shift ，
 * 然后在 求值并记录 字段中输入 表达式 即可。
 *
 * @author OldFriend
 */
public class TestNonSuspendingBreakpoints {
    public static void main(String[] args) {
        System.out.println(testMethod(111112));
        System.out.println(testMethod("2024-10-3"));
    }

    public static int testMethod(int testValue) {
        if (testValue > 11111) {
            testValue += 1000;
        }
        return testValue;
    }

    public static String testMethod(String testData) {
        if (testData.equals("2024-10-03")) {
            testData = "1997-6-29";
        }
        return testData;
    }
}
