import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

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
 * 方法一：广度优先
 * 时间复杂度：O(n)， n 为节点数
 * 空间复杂度：O(n)
 */
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results; // 判空
        // 维护一个队列来存放按层序排好的节点们
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            // 每层维护一个栈来存放层节点
            List<Integer> levelResults = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levelResults.add(node.val);
                queue.addAll(node.children);
            }
            results.add(levelResults);
        }
        return results;
    }
}
// @lc code=end

