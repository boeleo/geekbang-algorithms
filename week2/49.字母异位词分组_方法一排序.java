import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 */

/**
 * 方法一：排序法
 * 时间复杂度：O(n * slogs)，其中 n 为字符串个数，s 为字符串最大字母个数。需要遍历 n 个字符串，每个字符串需要 O(slogs) 的时间来排序，以及 O(1) 来更新哈希表；
 * 空间复杂度：O(ns)，为哈希表空间开销。
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 维护一个哈希表，表键为排列好的字母组合
        // 按照表键将字符串分类，然后返回只输出表值。
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

