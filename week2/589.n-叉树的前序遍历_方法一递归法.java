import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
 * 方法一：递归法
 * 时间复杂度：O(M)，M 为 N 叉树的节点数
 * 空间复杂度：O(M)
 */
class Solution {
    LinkedList<Integer> output = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return output;
        traverse(root);
        return output;
    }

    private void traverse(Node root) {
        // 前序，先遍历 root
        output.add(root.val);

        for (Node child : root.children) {
            traverse(child);
        }
    }
}
// @lc code=end

