package org.silence.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author xieshijin
 */
@Slf4j
public class Solution5 {

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * <p>
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            //前面两个循环都是解决  对称中心点问题
            //判断左边 如果等于当前 向左移
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                --left;
            }
            // 判断右边  如果等于当前 就向右移
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                ++right;
            }
            //解决中心点 就像左右扩散
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            //比较长度  更新最大长度下标
            if (right - left > rightIndex - leftIndex) {
                leftIndex = left;
                rightIndex = right;
            }
        }

        return s.substring(leftIndex+1, rightIndex);
    }

    @Test
    public void test() {
        String babad = longestPalindrome("babad");
        log.info(babad);
    }


}
