package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] a) {
        // 这个间隔来自动knuth序列
        int h = 1;
        while (h < a.length) h = h * 3 + 1;
        while (h >= 1) {
            // 注意，这里是从h开始，因为0只能插在原来的位置
            for (int i = h; i < a.length; i++) {
                // a[j] < a[j - h] 这个是中止条件，插入的位置
                for (int j = i; j >= h && a[j] < a[j - h]; j = j - h) {
                    // 交换结果
                    int temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
