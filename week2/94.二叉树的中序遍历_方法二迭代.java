import java.util.ArrayList;
import java.util.Deque;
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
 * 方法二：迭代法
 * 时间复杂度：O(n)，n 为结点数
 * 空间复杂度：O(n)，取决于栈的深度。
 */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        while(root != null || !stk.isEmpty()) {
            // 将左结点入栈
            while(root != null) {
                stk.push(root);
                root = root.left;
            }

            // 中序遍历：左、中、右
            root = stk.pop();
            results.add(root.val);
            root = root.right;
        }
        return results;
    }
}
// @lc code=end

