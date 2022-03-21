package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序，快速排序有几种方式：
 * 1、对换后，再把最后一个小于的跟目标不值对换（当前方式）
 * 2、把第一个值提取出来，然后进行交替换坑的方式
 * @author xueyingbing
 * @date 2022/3/22
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int j = partition(a, l, r);
        // 因为j的位置是正确的，所以要排除掉j
        sort(a, l, j - 1);
        sort(a, j + 1, r);
    }

    public static int partition(int[] a, int l, int r) {
        int first = l, last = r + 1;
        int v = a[l];
        while (true) {
            // 向右找出大于目标值的下标
            while (a[++first] < v) if (first == r) break;
            // 向左找出小于目标值的下标
            while (a[--last] > v) if (last <= l) break;
            // 找不到，直接放弃
            if (first >= last) break;
            // 找到以后，更换然后继续
            int temp = a[first];
            a[first] = a[last];
            a[last] = temp;
        }
        // last 跟 l 交换(前提是不相等，因为相等没必要交换)
        if (last != l) {
            a[l] = a[last];
            a[last] = v;
        }
        // 这样，last的位置就一定是正确的
        return last;
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
