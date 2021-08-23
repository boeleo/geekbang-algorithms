/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先
 * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 方法二：递归 (更简洁)
 * 时间复杂度：O(n)，其中 n 是二叉树的节点数。二叉树的所有节点有且只会被访问一次；
 * 空间复杂度：O(n)，递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，
 * 此时高度为 n，因此空间复杂度为 O(nß)。
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // terminator 
        if(root == null || root == p || root == q) return root;
        // split problem
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // process results
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
// @lc code=end

