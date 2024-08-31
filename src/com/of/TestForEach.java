package com.of;

public class TestForEach {
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}};
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
            }
        }

        int[][][][] fourDimensionalArray = {
                {
                        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        {{13, 14, 15, 16}, {17, 18, 19, 20}, {21, 22, 23, 24}}
                },
                {
                        {{25, 26, 27, 28}, {29, 30, 31, 32}, {33, 34, 35, 36}},
                        {{37, 38, 39, 40}, {41, 42, 43, 44}, {45, 46, 47, 48}}
                }
        };

        for (int[][][] ints1 : fourDimensionalArray) {
            for (int[][] ints2 : ints1) {
                for (int[] ints3 : ints2) {
                    for (int i : ints3) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
