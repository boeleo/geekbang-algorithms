/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *  注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */

 /**
    方法二： 哈希表法
    时间复制度：O(n)，n为字符串的长度；
    空间复杂度：O(m)，m为用于生成字符出现次数表的字符集长度。
 */ 

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        // 长度不同可以直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 维护一个s字符出现次数表
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        // 遍历t
        for (int i = 0; i < t.length(); i++) {
            // 出现字母次数为0说明有不同字符，可以直接返回false
            if (table[t.charAt(i) - 'a'] == 0) return false;
            // 遍历过的字符，表里出现次数减一
            table[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
// @lc code=end

