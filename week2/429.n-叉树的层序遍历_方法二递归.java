import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
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
/**
 * 方法二：递归
 * 时间复杂度：O(n)， n 为节点数
 * 空间复杂度：O(n)， 正常情况是 O(logn)，最坏情况是 O(n)
 */
class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) return traversal(root, 0);
        return results;
    }

    private void traversal(Node node, int level) {
        if (results.size() <= level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(node.val);
        for (Node child : node.children) {
            traversal(child, level + 1);
        }
    }
}
// @lc code=end

