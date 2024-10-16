package com.of;

import com.of.entity.Car;

/**
 * 测试自定义数据渲染器
 *
 * @author OldFriend
 */
public class TestCustomDataRenderers {
    public static void main(String[] args) {
        Car bwm = new Car("宝马X5", 3800000D, "黑色");
        Car byd = new Car("比亚迪秦Plus", 1800000D, "白色");
        System.out.println(bwm);
        System.out.println(byd);
    }
}
