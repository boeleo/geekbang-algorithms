/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */

/**
 * 方法一：暴力法 （超出时间限制）
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0 || n == 1) return n;
        int ugly = 0;
        for (int i = 0; i <= n; i++) {
            if(isUgly(i)) ugly++;
        }
        return ugly;
    }
    private boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
// @lc code=end

