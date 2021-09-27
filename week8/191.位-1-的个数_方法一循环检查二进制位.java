/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */

// @lc code=start
// 方法一： 循环检查二进制位是否为 1
// 时间复杂度： O(k)，k 为输入的二进制数的位数
// 空间复杂度：O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        // 由于题目规定 “输入必须是长度为 32 的二进制串”
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) result++;
        }
        return result;
    }
}
// @lc code=end

