package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void sort(int[] a) {
        // 注意，这里是从1开始，因为0只能插在原来的位置
        for (int i = 1; i < a.length; i++) {
            // a[j] < a[j - 1] 这个是中止条件，插入的位置
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                // 交换结果
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5,1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
