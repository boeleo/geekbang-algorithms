import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *  
 * 提示：
 *  1 <= g.length <= 3 * 104
 *  0 <= s.length <= 3 * 104
 *  1 <= g[i], s[j] <= 231 - 1
 */
/**
 * 方法：排序+贪心
 * 先将两个数组进行排序，确保孩子胃口大小数组以及可供饼干大小数组都是按照有小到大排序，
 * 这样，从贪心的角度，对于每个孩子，只要能找出剩下饼干中满足孩子胃口的最小的饼干即可。
 * 由于两数组都是递增的，那么不满足 i 孩子的 j 饼干也不会满足 i+1 孩子，因此可以滤
 * 掉，继续比较下一块饼干。
 * 
 * 时间复杂度：O(mlogm + nlogn)， 其中 m 为数组 g 的大小，n 为数组 s 的大小。
 *          两个数组排序需要 O(mlogm + nlogn)，遍历两个数组需要 O(m + n)，
 *          因此时间复杂度为 O(mlogm + nlogn)。
 * 空间复杂度：O(log⁡m+log⁡n)，为排序的额外开销。
 */
// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 初始状态
        int result = 0, numOfChildren = g.length, numOfCookie = s.length;
        // 数组排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 遍历
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookie; i++, j++) {
            // 滤掉 不满足 i 孩子胃口的饼干们
            // 首先要判定边界
            while (j < numOfCookie && s[j] < g[i]) {
                j++;
            }
            // 若滤完还有剩饼干
            if (j < numOfCookie) {
                result++;
            }
        }
        // 返回最大值
        return result;
    }
}
// @lc code=end

