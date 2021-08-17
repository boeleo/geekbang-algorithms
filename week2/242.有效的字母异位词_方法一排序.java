/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *  注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */

/**
    方法一： 排序比较法
    时间复制度：O(nlogn)，排序的时间复杂度为O(nlogn)，比较的时间复杂度为O(n)，
        所以总体时间复杂度为O(nlogn + n) = O(nlogn)；
    空间复杂度：O(logn)，排序的空间复杂度为O(logn)，字符串转换为char[]的空间
        复杂度依赖语言细节和函数细节，因此忽略。
 */ 

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
            // 长度不同可以直接返回
            if (s.length() != t.length()) {
                return false;
            }

            // 字符串转换为字符列表
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            // 利用Arrays库函数排序
            Arrays.sort(sChars);
            Arrays.sort(tChars);

            // 返回列表是否相同即可
            return Arrays.equals(sChars, tChars);
        }
    }
}
// @lc code=end

