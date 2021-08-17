import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

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
 * 方法二：迭代法
 * 时间复杂度：O(M)，M 为 N 叉树的节点数
 * 空间复杂度：O(M)
 */
class Solution {
    LinkedList<Integer> output = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return output;
        // 创建一个栈，保证栈顶的节点就是当前遍历到的节点
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            // 把子节点反转之后可以确保节点们反向入栈，然后正向出栈
            Collections.reverse(node.children);

            for (Node child : node.children) {
                stack.add(child);
            }
        }

        return output;
    }
}
// @lc code=end

