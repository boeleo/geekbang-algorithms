import java.util.ArrayList;
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
 * 方法二：计数法
 * 时间复杂度：O(n(s + |∑|))，其中 n 为字符串个数，s 为字符串最大字母个数，∑ 为字母集个数，本题均为小写字母，所以 ∑ 为 26。需要遍历 n 个字符串，每个字符串需要 O(s) 的时间来统计出现的次数，以及 O(1) 来更新哈希表；
 * 空间复杂度：O(n(s + |∑|))，为哈希表空间开销。
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 维护一个哈希表，由于互为字母异位词的两个字符串包含的字母相同，
        // 可以用字母及其出现次数的组合作为哈希表的表键分类字符串。
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int len = str.length();
            // 统计字母出现次数
            for (int i = 0; i < len; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 使用字母及其出现次数构建表键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                sb.append((char) ('a' + i));
                sb.append(counts[i]);
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

