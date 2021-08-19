import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */

/**
 * 方法一：最小堆 (此方法非好方法，还有暴力法和动态规划，此处未实现)
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        // 使用 Set 来去重
        // 数据类型采用 Long 而不是 Integer，
        // 由于题中提到 n 不超过 1690
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
// @lc code=end

