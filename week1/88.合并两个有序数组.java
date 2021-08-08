/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * 方法一：直接合并然后排序；时间复杂度：O((m+n)log⁡(m+n)) 空间复杂度：O(log⁡(m+n))。
 * 方法二：双指针；时间复杂度：O(m+n) 空间复杂度：O(m+n)。
 * 方法三：逆向双指针；时间复杂度：O(m+n) 空间复杂度：O(1)。
 */

// @lc code=start
class Solution {
    // 解法：逆向双指针；
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, current;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                current = nums2[p2--];
            } else if (p2 == -1) {
                current = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                current = nums1[p1--];
            } else {
                current = nums2[p2--];
            }
            nums1[tail--] = current;
        }
    }
}
// @lc code=end

