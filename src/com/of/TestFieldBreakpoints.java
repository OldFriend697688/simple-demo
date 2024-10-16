package com.of;

/**
 * 测试字段断点或字段观察点
 *
 * @author OldFriend
 */
public class TestFieldBreakpoints {
    public static void main(String[] args) {
        Game redAlert = new Game("红色警戒2","即时战略",15.2);
        System.out.println("游戏名称:" + redAlert.getName());
        System.out.println("游戏类型:" + redAlert.getType());
        System.out.println("游戏售价:" + redAlert.getPrice());
    }

    static class Game {
        private String name;
        private String type;
        private double price;

        public Game() {
        }

        public Game(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
