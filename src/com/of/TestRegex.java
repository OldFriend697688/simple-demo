package com.of;

/**
 * 测试正则表达式的应用
 *
 * @author OldFriend
 */
public class TestRegex {
    private static final String PHONE_NUMBER_REGEX = "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    public static void main(String[] args) {
        isValidPhoneNumber(new String[]{"13618631459", "18827642238", "17067692399"});
        testReplace("我们既要这样啊这个又要那样这个还要如此这个啊啊啊这个更要如此");
        testSplit("小红50000 小兰9000，小黑20000 小名-50");
    }

    /**
     * 验证手机号码是否符合规范
     *
     * @param phoneNumbers 要验证的手机号
     */
    public static void isValidPhoneNumber(String... phoneNumbers) {
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber.matches(PHONE_NUMBER_REGEX) ? phoneNumber + "是正确的手机号码" : phoneNumber + "不是正确的手机号码");
        }
        System.out.println("");
    }

    /**
     * 测试将匹配的字符替换为目标字符
     *
     * @param text 目标文本
     */
    public static void testReplace(String text) {
        System.out.println(text.replace("啊", "，").replace("这个", "，"));
        System.out.println(text.replaceAll("(啊|这个)+", "，"));
        System.out.println(text.replaceFirst("(啊|这个)+", "，"));
        System.out.println();
    }

    /**
     * 测试分割目标字符
     *
     * @param text 目标文本
     */
    public static void testSplit(String text) {
        String regex = "( +|，)";
        String[] strs = text.split(regex);
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println();
        strs = text.split(regex, 2);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
