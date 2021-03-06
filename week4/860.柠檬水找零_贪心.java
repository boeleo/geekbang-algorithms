/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，
 * （按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
 * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */

// @lc code=start
/**
 * 方法：贪心
 * 思路：由于顾客只能买一杯（5美元），也只可能给出 5、10、20 这三种面值，
 * 按顾客支付金额分三种情况讨论：
 * 1. 5美元 ：无需找零；
 * 2. 10美元：需要找回 5 美元，如果没有 5美元零钱，只能返回 false；
 * 3. 20美元：需要找回 15 美元，找回金额数量可分为两种情况，
 *    1) 1 张 10 美元和 1 张 5 美元；
 *    2）3 张 5 美元；
 * 因此，只需维护两个变量 five 和 ten 来保存手头上现有的 5 美元和 10 美元
 * 的数量，然后遍历账单数据即可。
 * 
 * 时间复杂度：O(n)，需要遍历账单数组；
 * 空间复杂度：O(1)，两个用于保存现有零钱数的变量。
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 一开始手头没有任何零钱，初始 five 和 ten 均为 0
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 顾客支付 5 美元
                five++; // 收下 5 美元
            } else if (bill == 10) {
                // 顾客支付 10 美元
                if (five == 0) {
                    // 无法找零
                    return false;
                }
                five--; // 找零 5 美元
                ten++;  // 收下 10 美元
            } else {
                // 顾客支付 20 美元
                if (five > 0 && ten > 0) {
                    // 有 5 美元和 10 美元的零钱
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 有 3 张及以上的 5 美元零钱
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

