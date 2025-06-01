package com.misuosi.ice.algorithm.sort;


import java.util.Arrays;

public class BubbleSort1 {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    min_index = j;
                }
            }
            if (min_index != -1 && a[i] > min) {
                a[min_index] = a[i];
                a[i] = min;
            }
        }
    }

    public static void sort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
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