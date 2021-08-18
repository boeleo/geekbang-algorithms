import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
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
 * 时间复杂度：O(n)，n 为节点数
 * 空间复杂度：O(n)，为存储遍历结果的开销。
 */
class Solution {
    List<Integer> results;

    public List<Integer> inorderTraversal(TreeNode root) {
        results = new ArrayList<Integer>();
        traversal(root);
        return results;
    }

    private void traversal(TreeNode root) {
        if (root == null) return; // 判空
        
        // 中序遍历：左、中、右
        traversal(root.left);
        results.add(root.val);
        traversal(root.right);
    }
}
// @lc code=end

