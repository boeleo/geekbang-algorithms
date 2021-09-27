/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。
 * 如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */

// @lc code=start
// 解法： 一个数 n 是 2 的幂，当且仅当 n 是正整数，
// 并且 n 的二进制表示中仅包含 1 个 1。
// 可以利用 n & (n−1)，把 n 的二进制位中的最低位的 1 变为 0，
// 如果刚好为 0，则满足上述条件。
// 时间复杂度： O(1)
// 空间复杂度：O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
// @lc code=end

