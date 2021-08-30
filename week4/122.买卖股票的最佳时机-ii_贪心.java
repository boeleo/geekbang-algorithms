/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
// @lc code=start
/**
 * 方法一：贪心
 * 由于股票的购买没有限制，从贪心的角度考虑，每次选择收益大于 0 的区间，可以使
 * 收益最大化。
 * 
 * 时间复杂度：O(n)，需要遍历 prices；
 * 空间复杂度：O(1)。
 */
class Solution {
    public int maxProfit(int[] prices) {
        // 收益
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            // 累加 0 与 每日股票差值的最大值
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        // 最大化的收益
        return result;
    }
}
// @lc code=end

