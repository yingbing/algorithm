package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author xueyingbing
 * @date 2022/3/22
 */
public class BubbleSort {

    public static void sort(int[] a) {
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
