package com.of;

/**
 * 测试从历史记录中粘贴内容
 *
 * @author OldFriend
 */
public class TestPasteFromHistory {
    static boolean b1 = false;

    public static void main(String[] args) {
        // int age = 29;
        // if (testMethod(age)) {  // 使用 ! 代表对得到的结果进行取反，这意味着 !false = true
        //     System.out.println("如果返回值为 true 则输出这句话!!");
        // }
        //  testMethod2();
        if (isPasswordInvalid("666888")) {  // 注意这里使用了新的函数名，但没有更新条件逻辑
            // 允许用户登录  // 错误：这将允许无效密码的用户登录
            System.out.println("登录成功!!");
        } else {
            // 显示错误消息，要求用户输入一个有效的密码
            System.out.println("密码不合法!!");
        }

        System.out.println(b1);
    }

    public static boolean testMethod(int age) {
        if (age > 30) {
            return true;
        } else {
            System.out.println("=====");
            return false;
        }
    }

    public static void testMethod2() {
        boolean flag = false;
        while (flag) { // 如果 flag 为 true 则会进入死循环状态
            System.out.println("这句话会被一直循环输出!!");
        }
    }

    public static boolean isPasswordInvalid(String password) {
        // 密码无效性检查逻辑
        if (password.length() < 8) {
            return false;
        }
        // 其他无效性检查...
        return true;
    }
}
