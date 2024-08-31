package com.of;

import java.util.Objects;

public class TestRefactorings {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("宝马");
        hero.setPrice(200000.00);
        hero.setType("X5");
        System.out.println(testMethod(1, 1, 2, 3));
    }

    private static int testMethod(int a, int... b) {
        int result = 0;
        for (int i : b) {
            result += i;
        }
        return result + a;
    }
}

class Hero {
    private String name;
    private String type;
    private double price;

    public Hero(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Hero() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Double.compare(hero.price, price) == 0 && Objects.equals(name, hero.name) && Objects.equals(type, hero.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price);
    }
}
