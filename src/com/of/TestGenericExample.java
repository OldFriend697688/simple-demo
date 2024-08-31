package com.of;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试泛型相关知识
 *
 * @author OldFriend
 */
public class TestGenericExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 创建 QQ 、WeChat 两个应用程序的对象
        QQ qq = new QQ("QQ", "即时通讯", "9.2.1");
        WeChat weChat = new WeChat("WeChat", "即时通讯", "3.2.5");

        // 创建应用程序管理器对象并指定类型参数 T 的类型为 Application
        ApplicationManager<Application> applicationManager = new ApplicationManager<>();
        System.out.println("AppID:" + applicationManager.getAppId(qq));
        System.out.println("FixMessage:" + applicationManager.fix(qq, "QQ 登录异常闪退问题被修复了!!"));
        System.out.println("AppID:" + applicationManager.getAppId(weChat));
        System.out.println("FixMessage:" + applicationManager.fix(weChat, "WeChat 发送图片异常卡死的问题被修复了!!"));

        // 创建应用程序管理器对象并指定类型参数 T 的类型为 Object，如果不指定则默认为 Object
        // ApplicationManager applicationManager1 = new ApplicationManager();
        // applicationManager1.getAppId(qq);
        // applicationManager1.getAppId(weChat);
        // applicationManager1.getAppId(new Person()); // 符合代码逻辑但不符合现实逻辑

        // 创建应用程序管理器 V2 版本的对象
        // ApplicationManagerV2<Person> applicationManagerV2 = new ApplicationManagerV2<>(); // 受上界约束，这行代码存在编译时错误
        ApplicationManagerV2<Application> applicationManagerV2 = new ApplicationManagerV2<>();
        System.out.println("AppID:" + applicationManagerV2.getAppId(qq));
        System.out.println("FixMessage:" + applicationManagerV2.fix(qq, "QQ 登录异常闪退问题被修复了!!"));
        System.out.println("AppID:" + applicationManagerV2.getAppId(weChat));
        System.out.println("FixMessage:" + applicationManagerV2.fix(weChat, "WeChat 发送图片异常卡死的问题被修复了!!"));
        // applicationManagerV2.getAppId(new Person());  // 受上界约束，只能够传递 Application 自身及其子类

        // 测试使用通配符
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        // 无界通配符
        WildcardTestUtil.printListElements(Arrays.asList(1, 2, 4, '6'));

        // 下界通配符
        WildcardTestUtil.sumNumbers(numberList);
        WildcardTestUtil.sumNumbers(intList);
        // WildcardTestUtil.sumNumbers(stringList);

        // 上界通配符
        ArrayList<Object> objectArrayList = new ArrayList<>();
        WildcardTestUtil.addNumbersToList(objectArrayList);
        // WildcardTestUtil.addNumbersToList(stringList);

        BasicDao<Person> personBasicDao = new BasicDao<>();
        System.out.println(personBasicDao.login(new Person()));

    }

    static class BasicDao<T> {
        public <T extends Person> List<? extends T> login(T t) {
            List<T> list = new ArrayList<>();
            list.add(t);
            // 返回时，我们返回一个 T 类型元素的列表，但由于返回类型声明为 ? extends T，
            // 编译器将把它视为 T 或 T 的子类的列表。
            return list; // 这里不需要强制类型转换
        }

        private List<T> list;

        public List<T> getList() {
            return this.list;
        }
    }

    /**
     * 通配符测试工具类
     * <p>
     */
    static class WildcardTestUtil {
        /**
         * 此方法中的形参使用了无界通配符，它等同于 <? extend Object>，
         * 这意味着此方法可以接受所有类型的参数，在使用时需要小心慎重，
         * 当只需要读取列表中的元素而不进行修改时，或者当方法内部不需要知道列表的确切类型时才应使用无界通配符，
         * 使用无界通配符将不能添加元素，这是因为编译器根本不知道此时类型参数的具体类型到底是什么.
         */
        public static void printListElements(List<?> list) {
            list.forEach(System.out::println); // 此处使用 JDK 8 中的新增特性方法引用
        }

        /**
         * 使用上限通配符，可以接受所有 Number 或其子类类型的 List。
         *
         * @param numberList 包含 Number 或其子类的列表
         */
        public static void sumNumbers(List<? extends Number> numberList) {
            double sum = 0;
            for (Number num : numberList) {
                sum += num.doubleValue();
            }
            System.out.println("Sum: " + sum);
        }

        /**
         * 使用下限通配符，可以向 List 中添加任何 Number 及其超类的元素。
         *
         * @param list 包含 Number 或其超类的列表
         */
        public static void addNumbersToList(List<? super Number> list) {
            // 错误， Integer 和 Double 是 Number 的子类
            // list.add(new Integer(1));
            // list.add(new Double(2.5));
            list.add(new Number() {
                @Override
                public int intValue() {
                    return 0;
                }

                @Override
                public long longValue() {
                    return 0;
                }

                @Override
                public float floatValue() {
                    return 0;
                }

                @Override
                public double doubleValue() {
                    return 0;
                }
            });
        }
    }

    /**
     * 应用程序管理器（未使用泛型通配符约束类型参数允许的类型范围）
     * <p>
     * 这是一个泛型类，它声明了一个名为 T 的类型参数，
     * 在此版本的实现中存在着一个巨大的缺陷，由于未对 T 做任何界限限制，
     * 这将有可能会导致存在符合代码逻辑但不符合实际现实逻辑的业务代码出现，比如有一个 Person 类：
     * <pre>
     * class Person {
     *     // .... 省略各种变量
     *     // .... 省略各种方法
     * }
     * </pre>
     * 这将会有可能错误的将 Person 类指定给 ApplicationManager，比如：
     * <pre>
     * public static void main(String[] args) {
     *     Person p = new Person();
     *     ApplicationManager<Person> manager = new ApplicationManager<>();
     * }
     * </pre>
     * 虽然这是符合代码逻辑的，但显然不符合现实逻辑，Person 类所代表的是人而不是应用程序，
     * 如果要对类型参数的可接受类型范围进行控制，则应该使用泛型通配符来避免出现这样的问题.
     */
    static class ApplicationManager<T> {
        /**
         * 修复应用程序的运行问题
         *
         * @param fixMessage 修复信息
         */
        public String fix(T t, String fixMessage) {
            return fixMessage;
        }

        /**
         * 获取应用程序的 ID
         *
         * @param t 目标应用程序
         */
        public String getAppId(T t) throws NoSuchFieldException, IllegalAccessException {
            return (String) t.getClass().getSuperclass().getDeclaredField("appId").get(t);
        }
    }

    /**
     * 应用程序管理器 V2（未使用泛型上界通配符约束类型参数允许的类型范围）
     * <p>
     * 这是一个泛型类，它声明了一个名为 T 的类型参数，并使用了泛型上界通配符约束类型参数可接受的类型范围，
     * 相较于 {@link ApplicationManager} 的实现而言，此版本的实现约束类型参数 T 只能够接受
     * {@link Application} 自身及其子类的类型，这样可以避免编写出符合代码逻辑但不符合现实逻辑的代码.
     */
    static class ApplicationManagerV2<T extends Application> {
        /**
         * 修复应用程序的运行问题
         *
         * @param fixMessage 修复信息
         */
        public String fix(T t, String fixMessage) {
            return fixMessage;
        }

        /**
         * 获取应用程序的 ID
         *
         * @param t 目标应用程序
         */
        public String getAppId(T t) throws NoSuchFieldException, IllegalAccessException {
            return (String) t.getClass().getSuperclass().getDeclaredField("appId").get(t);
        }
    }

    /**
     * 所有应用程序的父类（超类）
     * <p>
     * 这个类是一个抽象类，它提供所有应用程序应当具备的通用属性和通用方法
     */
    static abstract class Application {
        public String appId;
        public String appType;
        public String version;

        public Application() {
        }

        public Application(String appId, String appType, String version) {
            this.appId = appId;
            this.appType = appType;
            this.version = version;
        }

        /**
         * 启动方法
         */
        public abstract String start();

        /**
         * 退出方法
         */
        public abstract String exit();

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    /**
     * WeChat 应用程序
     */
    static class WeChat extends Application {
        public WeChat() {
        }

        public WeChat(String appId, String appType, String version) {
            super(appId, appType, version);
        }

        @Override
        public String start() {
            return this.appType + "类型应用" + this.appId + "版本：" + this.version + "已成功启动!!";
        }

        @Override
        public String exit() {
            return this.appId + "已退出";
        }

        @Override
        public String toString() {
            return "WeChat{" +
                    "appId='" + appId + '\'' +
                    ", appType='" + appType + '\'' +
                    ", version='" + version + '\'' +
                    '}';
        }
    }

    /**
     * QQ 应用程序
     */
    static class QQ extends Application {
        public QQ() {
        }

        public QQ(String appId, String appType, String version) {
            super(appId, appType, version);
        }

        @Override
        public String start() {
            return this.appType + "类型应用" + this.appId + "版本：" + this.version + "已成功启动!!";
        }

        @Override
        public String exit() {
            return this.appId + "已退出";
        }

        @Override
        public String toString() {
            return "QQ{" +
                    "appId='" + appId + '\'' +
                    ", appType='" + appType + '\'' +
                    ", version='" + version + '\'' +
                    '}';
        }
    }

    /**
     * Person 类
     */
    static class Person {
        // ..... 省略变量和方法
    }
}


