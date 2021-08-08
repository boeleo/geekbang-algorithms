/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 方法一：暴力；时间复杂度：O(n^2) 空间复杂度： O(1)；
 * 方法二：动态规划；时间复杂度：O(n) 空间复杂度：O(n)；
 * 方法三：双指针；时间复杂度：O(n) 空间复杂度：O(1)；
 * 方法四：栈；时间复杂度：O(n) 空间复杂度：O(n)；
 */

// @lc code=start
class Solution {
    // 双指针法
    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }
}
// @lc code=end

