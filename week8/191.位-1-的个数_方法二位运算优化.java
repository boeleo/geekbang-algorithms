/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */

// @lc code=start
// 方法二： 位运算优化，利用 n & (n−1)，刚好把 n 的二进制位中的最低位的 1 变为 0。
// 时间复杂度： O(logk)，k 为输入的二进制数的位数
// 空间复杂度：O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n) {
            n &= (n - 1);
            result++;
        }
        return result;
    }
}
// @lc code=end

