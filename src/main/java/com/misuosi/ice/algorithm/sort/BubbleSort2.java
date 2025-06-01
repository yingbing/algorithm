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


    public static void sort1(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int maxIndex = 0;
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
