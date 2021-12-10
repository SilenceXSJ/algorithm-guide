package org.silence.leetcode;

public class Solution543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        deep(root);

        return ans - 1;
    }


    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = deep(node.left);
        int r = deep(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
