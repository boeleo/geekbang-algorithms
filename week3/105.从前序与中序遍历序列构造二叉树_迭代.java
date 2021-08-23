/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
 * 前序遍历：根、左、右；
 * 中序遍历：左、根、右；
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
 * 方法二：迭代
 * 时间复杂度：O(n)，其中 n 是树中的节点个数。
 * 空间复杂度：O(n)，栈的开销
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // 用一个栈 stack 来维护 当前节点的所有还没有考虑过右儿子的祖先节点
        // 栈顶就是当前节点
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        // index 对应的节点是 当前节点不断往左走达到的最终节点
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                // index 和栈顶节点不同，
                // 将当前节点作为栈顶节点的左儿子
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // index 恰好指向栈顶节点
                // 不断地弹出栈顶节点并向右移动 index
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // 并将当前节点作为最后一个弹出的节点的右儿子
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
// @lc code=end

