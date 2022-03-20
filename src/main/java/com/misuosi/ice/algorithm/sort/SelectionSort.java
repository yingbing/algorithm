package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序/冒泡排序
 */
public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            // 获取往后的最小值
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            // 把最小值和当前排序值交换
            if (min != i) {
                int minValue = a[min];
                a[min] = a[i];
                a[i] = minValue;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5,1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
