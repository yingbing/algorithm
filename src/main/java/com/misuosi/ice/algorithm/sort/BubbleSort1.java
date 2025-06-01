package com.misuosi.ice.algorithm.sort;


import java.util.Arrays;

public class BubbleSort1 {

    @Deprecated
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

    /**
     * 这里主要优化点在于，这里不需要记录最小值，只需要记录最小值的索引，然后交换位置
     */
    public static void sort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // 这是的默认值是i, 所以每个重置的节点都参与了比较，因此最后不需要再和minIndex的位置进行比较
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 这里就是不需要再比较的位置，只需要判断下标是否一致就可以了
            // 其实更好的做法可能是 a[minIndex] != a[i]，但是差别不大，但是理解起来更加费劲
            // 其实a[minIndex] <  a[i]可能更好理解，我也实现了这种做法，可以看BubbleSort2的实现。
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