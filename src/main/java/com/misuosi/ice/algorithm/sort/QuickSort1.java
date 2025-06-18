package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 具体的实现算法可参考视频：https://www.bilibili.com/video/BV1y4421Z7hK/
 */
public class QuickSort1 {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) return;
        int split_index = part(a, left, right);
        sort(a, left, split_index - 1);
        sort(a, split_index + 1, right);
    }

    private static int part(int[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] > pivot) right--;
            a[left] = a[right];
            while (left < right && a[left] < pivot) left++;
            a[right] = a[left];
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] a = {9, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
