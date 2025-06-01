package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

public class BubbleSort4 {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {11, 0};
        sort(b);
        System.out.println(Arrays.toString(b));

        int[] c = {11};
        sort(c);
        System.out.println(Arrays.toString(c));

        int[] d = {};
        sort(d);
        System.out.println(Arrays.toString(d));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
