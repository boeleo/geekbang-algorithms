/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 */

// @lc code=start
/**
 * 方法：回溯
 * 时间复杂度：O(n×n!)，其中 n 为序列的长度。
 * 空间复杂度：O(n)。
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, 0);
        return res;
    }

    /**
     * 从左往右填到第 first 个位置，当前排列为 output
     * @param n
     * @param output
     * @param first
     */
    private void backtrack(int n, List<Integer> output, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
// @lc code=end

