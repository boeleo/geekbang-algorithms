/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 给定一个可包含重复数字的序列 nums ，
 * 按任意顺序 返回所有不重复的全排列。
 * 注：与 46 题的不同之处就是给定数组可包含重复数字。
 */

// @lc code=start
/**
 * 46 题的解法加判重条件
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        // 与 46 题 解法唯一不同的地方：
        // 插入之前先判断时候已存在
        if (first == n && !res.contains(output)) {
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

