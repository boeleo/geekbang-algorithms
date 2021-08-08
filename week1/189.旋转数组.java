/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
    方法一：采用额外的数组，用取模的方式将元素放到正确的位置；
    方法二：环状替代；
    方法三：数组翻转；
 */

// @lc code=start
class Solution {
    // 解法：数组翻转；
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
// @lc code=end

