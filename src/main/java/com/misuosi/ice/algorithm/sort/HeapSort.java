package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

/**
 * 堆的重要性质/完全二叉树的重要性质
 *         parent = (i - 1) /2;
 *         c1 = 2i + 1;
 *         c2 = 2i + 2;
 * 可以看这个视频：
 * https://www.bilibili.com/video/BV1HYtseiEQ8/
 * @author xueyingbing
 * @date 2022/3/21
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] tree = {2, 5, 3, 1, 10, 4, 11, 8, 32, 9, 28};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(tree, tree.length);
        System.out.println(Arrays.toString(tree));
    }

    public void sort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i >= 0; i--) {
            // 交换第0个和最后一个，最后一个就已经排好的了
            int temp = tree[i];
            tree[i] = tree[0];
            tree[0] = temp;
            heapify(tree, i, 0);
        }
    }

    private void buildHeap(int[] tree, int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    /**
     * 大顶堆的堆化
     */
    private void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int maxI = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && tree[maxI] < tree[left]) {
            maxI = left;
        }
        if (right < n && tree[maxI] < tree[right]) {
            maxI = right;
        }
        if (maxI != i) {
            int temp = tree[i];
            tree[i] = tree[maxI];
            tree[maxI] = temp;
            heapify(tree, n, maxI);
        }
    }

}
