package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author xueyingbing
 * @date 2022/3/21
 */
public class MergeSort {

    public static void sort(int[] a) {
        sort(a, new int[a.length], 0, a.length - 1);
    }

    /**
     * 这里只是一个拆分，拆到一个元素为止，排序主要在于merge
     */
    public static void sort(int[] a, int[] temp, int l, int r) {
        if (r <= l) return;
        // 这里要注意边界问题，如果不注意就会出现死循环
        int m = (l + r) / 2;
        sort(a, temp, l, m);
        sort(a, temp, m + 1, r);
        merge(a, temp, l, m, r);
    }

    public static void merge(int[] a, int[] temp, int l, int m, int r) {
        // 复制到临时数据
        for (int i = l; i <= r; i++) temp[i] = a[i];

        // 从临时数据进行合并排序（滑动窗口）,简化写法，如果需要更详细，更容易理解的写法看下面
        int f = l, s = m + 1;
        for (int i = l; i <= r; i++) {
            if (f > m) a[i] = temp[s++];
            else if (s > r) a[i] = temp[f++];
            else if (temp[f] >= temp[s]) a[i] = temp[s++];
            else a[i] = temp[f++];
        }
        // 容易理解的写法
        /* int f = l, s = m + 1;
        for (int i = l; i <= r; i++) {
            if (f > m) {
                // first 已经遍历完了，只需要把second往后加
                a[i] = temp[s];
                s++;
            } else if (s > r) {
                // second 已经遍历完了，只需要把first往后加
                a[i] = temp[f];
                f++;
            } else if (temp[f] >= temp[s]) {
                // 合并最小的
                a[i] = temp[s];
                s++;
            } else {
                // temp[f] >= temp[s]
                a[i] = temp[f];
                f++;
            }
        }*/
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
