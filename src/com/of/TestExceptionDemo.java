package com.of;

public class TestExceptionDemo {
    public static void main(String[] args) {
        NetworkConnectionUtils.Account account = new NetworkConnectionUtils.Account();
        try {
            NetworkConnectionUtils.login(account);
        } catch (NetWorkConnectionException | LoginException e) {
            e.printStackTrace();
        }
        System.out.println("恢复了!");
    }
}

/**
 * 自定义一个受检异常（编译时异常）
 * <p>
 * 受检异常必须进行捕获或抛出处理
 */
class NetWorkConnectionException extends Exception {
    public NetWorkConnectionException(String message) {
        super(message);
    }
}


/**
 * 自定义一个非受检异常（运行时异常）
 * <p>
 * 非受检异常可以根据需要主动进行捕获或抛出，也可以不对它做任何处理
 */
class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}

/**
 * 网络连接工具类
 */
class NetworkConnectionUtils {
    private static String connection(String name, String password) throws NetWorkConnectionException {
        if (name.equals("Admin") && password.length() > 6) return "连接成功!!";
        else throw new NetWorkConnectionException("连接出现问题");
    }

    public static void login(Account account) throws NetWorkConnectionException, LoginException {
        connection(account.ADMIN_ACCOUNT, account.ADMIN_ACCOUNT_PWD);
    }

    static class Account {
        private static final String ADMIN_ACCOUNT = "Admin";
        private static final String ADMIN_ACCOUNT_PWD = "666_888_777";
        public int a = 1;

        public void testMethod() {
            System.out.println(ADMIN_ACCOUNT);
            System.out.println(a);
        }

        public static void staticMethod() {
            System.out.println(ADMIN_ACCOUNT);
        }
    }
}