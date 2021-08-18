import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 方法一：递归法
 * 时间复杂度：O(n)，n 为节点数，每个结点都需要遍历一次；
 * 空间复杂度：O(n)，递归中栈的开销。平均情况下为 O(logn)，最坏的情况为呈链状的树，为 O(n)。
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        traversal(root, results);
        return results;
    }

    private void traversal(TreeNode root, List<Integer> results) {
        if (root == null) return; // 判空
        // 前序遍历：中、左、右
        results.add(root.val);
        traversal(root.left, results);
        traversal(root.right, results);
    }
}
// @lc code=end

