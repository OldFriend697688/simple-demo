package com.of;

/**
 * 测试强制返回(Force Return)
 *
 * @author OldFriend
 */
public class TestForceReturn {
    public static void main(String[] args) {
        writerData();
    }

    public static void writerData() {
        System.out.println("bug..");

        System.out.println("DB 操作");
        System.out.println("将数据写入到 MySQL..");
        // 当执行强制返回操作后，其后面的输出语句都不会执行
        System.out.println("将数据写入到 Oracle..");
        System.out.println("将数据写入到 Redis..");
        System.out.println("将数据写入到 MongoDB..");
    }
}
