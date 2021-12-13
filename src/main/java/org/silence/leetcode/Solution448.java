package org.silence.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
