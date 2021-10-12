import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 */

// @lc code=start
// 方法一：自定义排序法
// 由于 arr2 中的元素各不相同，可以记录下其中各元素的位置，然后通过自定义排序排列 arr1
// 时间复杂度：O(mlogm + n)，
//    其中 m、n 分别为 arr1 和 arr2 的长度，mlogm 为 arr1 排序的时间，n 为构造 map 的时间。
// 空间复杂度：O(logm + n)，其中 logm 为排序需要的栈空间，n 为 构造 map 需要的空间。
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> arr1List = new ArrayList<Integer>();
        // Array 转换为 List
        for (int num : arr1) {
            arr1List.add(num);
        }

        // 记录 arr2 中的数及其位置
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        
        Collections.sort(arr1List, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                // 题中提示两个数组的长度在 1000 以内
                // 设置 1001 为默认位置可以确保不在 map 里的元素比存在的元素值大
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            } else {
                return x - y;
            }
        });

        // 把 List 转为 Array 返回
        for (int i = 0; i < arr1List.size(); i++) {
            arr1[i] = arr1List.get(i);
        }

        return arr1;
    }
}
// @lc code=end

