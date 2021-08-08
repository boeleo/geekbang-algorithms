/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

// @lc code=start
class Solution {
    // 双指针法
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
// @lc code=end

