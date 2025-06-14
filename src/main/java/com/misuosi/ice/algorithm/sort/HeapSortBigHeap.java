package com.misuosi.ice.algorithm.sort;

import java.util.Arrays;

public class HeapSortBigHeap {
    public static void sort(int[] tree) {
        // 1. 构建一模大顶堆的树
        buildHead(tree, tree.length - 1);
        for (int i = tree.length - 1; i >= 0 ; i--) {
            // 2. 把树最后一个元素摘下来
            int temp = tree[0];
            tree[0] = tree[i];
            tree[i] = temp;
            parentCompareAndSwap(tree, 0,  i - 1);
        }
    }

    public static void buildHead(int[] tree, int compute_length) {
        // 递归地排，从最后一个父节点开始
        int last_parent_index = (compute_length - 1) / 2;
        for (int parent_index = last_parent_index; parent_index >= 0; parent_index--) {
            parentCompareAndSwap(tree, parent_index, compute_length);
        }
    }

    public static void parentCompareAndSwap(int[] tree, int parent, int compute_length) {
        int max_index = parent;
        int left_index = parent * 2 + 1;
        int right_index = parent * 2 + 2;
        if (left_index <= compute_length && tree[max_index] < tree[left_index]) {
            max_index = left_index;
        }
        if (right_index <= compute_length && tree[max_index] < tree[right_index]) {
            max_index = right_index;
        }
        if (max_index != parent) {
            int temp = tree[parent];
            tree[parent] = tree[max_index];
            tree[max_index] = temp;
            parentCompareAndSwap(tree, max_index, compute_length);
        }
    }

    public static void main(String[] args) {
        int[] tree = {2, 5, 3, 1, 10, 4, 11, 8, 32, 9, 28};
        sort(tree);
        System.out.println(Arrays.toString(tree));
    }
}
