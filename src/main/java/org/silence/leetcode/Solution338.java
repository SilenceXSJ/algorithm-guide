package org.silence.leetcode;

public class Solution338 {
    int[] arr;

    public int[] countBits(int n) {
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = getBit(i);
        }
        return arr;
    }

    public int getBit(int n) {
        return (n & 1) + arr[n >>> 1];
    }
}
