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
 * 方法二：动态规划
 * 由于“不能同时参与多笔交易”，即每天交易结束后只存在 手上没有股票 或者 有一支股票 的状态。
 * 那么就此两情况分析：
 * 1）手上没有股票： 其利益最大就是 dp[i][0] = max { dp[i-1][0], dp[i-1][1] + prices[i] };
 * 2）有一支股票： 其利益最大就是 dp[i][1] = max { dp[i-1][1], dp[i-1][0] - prices[i] }
 * 对于初始状态 dp[0][0] = 0, dp[0][1] = -prices[0]。 因此，当所有交易结束时，持有股票的
 * 收益一定小于股票全部卖出的收益。可见 dp[n-1][0] 必然大于 dp[n-1][1]。
 * 因此最后答案即为 dp[n-1][0]。
 * 由于每天的状态只与前一天的状态有关，只需要将 dp[i-1][0] 和 dp[i-1][1] 存放即可。
 * 
 * 时间复杂度：O(n)，需要遍历整个股票价格数组；
 * 空间复杂度：O(1)，需要 dp0 和 dp1 来保存前一天交易结束的收益状态。
 */
class Solution {
    public int maxProfit(int[] prices) {
        // 手头没股票 和 手上有一支股票 的初始状态
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 第i天手头没股票的最大利益
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            // 第i天手上有一支股票的最大收益
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            // 转移作为第 i+1 天初始状态
            dp0 = newDp0;
            dp1 = newDp1;
        }
        // 最大化的收益
        return dp0;
    }
}
// @lc code=end

