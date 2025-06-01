package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

public class BubbleSort2 {

    @Deprecated
    public static void sort(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            int max_index = -1;
            for (int j = 0; j < i; j++) {
                if (a[j] > max) {
                    max = a[j];
                    max_index = j;
                }
            }
            if (max_index != -1 && max > a[i]) {
                a[max_index] = a[i];
                a[i] = max;
            }
        }
    }

    /**
     * 这里主要优化点在于，这里不需要记录最小值，只需要记录最小值的索引，然后交换位置
     */
    public static void sort1(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int maxIndex = 0;
            // 注意，这里的终止条件是 j < i, 因此i是不参与此次循环的，i的值需要在最后再做一次比较
            // 这样做的好处是，可以少一次循环，
            // 反正最后无论是比较maxIndex和i是否相等，还是比较值，都是要比较的，差别不大
            // 反正是无聊练习写代码，多想想总是好的
            for (int j = 1; j < i; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (a[maxIndex] > a[i]) {
                int temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort1(a);
        System.out.println(Arrays.toString(a));

        int[] b = {11, 0};
        sort1(b);
        System.out.println(Arrays.toString(b));

        int[] c = {11};
        sort1(c);
        System.out.println(Arrays.toString(c));

        int[] d = {};
        sort1(d);
        System.out.println(Arrays.toString(d));
    }
}
