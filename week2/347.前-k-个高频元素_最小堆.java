import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素
 * 你可以按 任意顺序 返回答案。
 */

/**
 * 方法：最小堆
 * 时间复杂度：O(nlogk)
 * 空间复杂度：O(n)
 */
// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 维护一个数据出现次数哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 保证以出现频率降序排列
                return map.get(a) - map.get(b);
            }
        });

        // 遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，
        // 则将顶部的元素删除并将该元素加入堆中，这里维护堆的数目是 k
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (map.get(key) > map.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
            results.add(heap.remove());
        }
        
        // ArrayList中规定的泛型是Integer，不能直接转化到int[]
        // 此处采用流操作来实现
        return results.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

