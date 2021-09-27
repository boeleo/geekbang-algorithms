/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 */

// @lc code=start
// 方法一：逐位颠倒
// 时间复杂度： O(logn)
// 空间复杂度：O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        // 题目中提到 “输入是一个长度为 32 的二进制字符串”
        for (int i = 0; i < 32 && n != 0; i++) {
            // 逐位颠倒
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }
}
// @lc code=end

