package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            if (min != i) {
                int minValue = a[min];
                a[min] = a[i];
                a[i] = minValue;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {11, 28, 10, 3, 4, 2, 5,1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}