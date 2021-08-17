import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */

/*
 * 方法二：哈希表法
 * 时间复杂度：O(n)，其中 n 为数组中元素的个数，通过哈希表查询 target - x 只需要 O(1) 的时间复杂度；
 * 空间复杂度：O(n)，此为哈希表的开销。
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 维护一个哈希表来存放整型列表里的值和位置对
        // 通过判断 target 和值的差是否在表里来找到它们的下标
        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashTable.containsKey(target - nums[i]))
                return new int[]{hashTable.get(target - nums[i]), i};
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

