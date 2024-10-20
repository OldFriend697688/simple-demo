package com.of;

/**
 * 测试热插拔
 * <p>
 * Java HotSwap VM 仅支持在调试中修改方法体中的内容，
 * 而不允许在调试过程中向类中添加新的方法、字段或是返回值等内容..
 * <p>
 * 如果想要实现上述效果，则需要使用 Dynamic Code Evolution VM，
 * 它是对 Java HotSwap VM 的一种修改，可以在运行时无限制地支持重载类..
 *
 * @author OldFriend
 */
public class TestHotSwap {
    public static void main(String[] args) {
        testMethod();
    }

    /**
     * 请注意，原生 Java HotSwap VM 仅支持修改方法体中的内容.
     * 所谓的方法体就是指 {} 中的内容，如果试图为方法增加或修改形参，
     * 又或者是修改方法的返回值类型等在原生 Java HotSwap VM 中是不被允许的.
     */
    public static void testMethod() {
        System.out.println("TestHotSwap.testMethod");
        System.out.println("这段话是后来添加的哦!!!");
    }
}
