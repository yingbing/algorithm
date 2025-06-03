package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

public class InsertionSort1 {

    /**
     * 插入排序，这种实现方式比InsertionSort有好处是，
     * 不用每一次都交换目标值，而是直接赋值给正确位置，理论上是比直接交换的效率高一些
     * 但这种实现方式有两种情况需要注意和特殊处理，下面实现有注释
     */
    @Deprecated
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                    // 这里需要判断边界，当j=0且需要交换的时候，即当前值比第一个还小，这个时候循不会再往下走，因此第0个位置需要手动赋值
                    if (j == 0) a[0] = temp;
                } else {
                    // j是初始值，即当前值为正确的位置，不需要进行交换，因此不用赋值
                    if (j != i - 1) a[j + 1] = temp;
                    break;
                }
            }
        }
    }

    /**
     * 优化后的版本，因为每次跳出循环后，上面那种实现都需要执行一次 a[j+1]=temp的赋值，即使是0，当第0个也大于当前值时， j是会变成-1的。
     * 因此跳出循环后统一操作即可。将判断跳件加到循环条件，则不需要break手动跳出。
     * 但是理论是最后是否重新赋值的判断是可以不需要的，但是我认为加上去的话，就可以不用多一次不必要的赋值。还是加上了，虽然不加更简洁。
     * 这版代码更简洁一些吧。
     */
    public static void sort1(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i], j = i - 1;
            for (; j >= 0 && a[j] > temp; j--) a[j + 1] = a[j];
            if (j != i - 1) a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort1(a);
        System.out.println(Arrays.toString(a));

        int[] e = {0, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        Arrays.sort(e);
        System.out.println(Arrays.toString(e));

        int[] f = {14, 11, 28, 10, 3, 4, 2, 5, 1, 8, 13, 24};
        sort1(f);
        System.out.println(Arrays.toString(f));

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
