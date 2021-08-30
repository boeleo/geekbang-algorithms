/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。
 * 该机器人可以接收以下三种类型的命令 commands ：
 *      -2 ：向左转 90 度
 *      -1 ：向右转 90 度
 *      1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。
 * 第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25）
 * 
 * 注意：
 *      北表示 +Y 方向。
 *      东表示 +X 方向。
 *      南表示 -Y 方向。
 *      西表示 -X 方向。
 */

// @lc code=start
/**
 * 方法：贪心
 * 每走一步都取现有结果与当前欧式距离的平方中的最大值更新结果
 * 详细思路见代码注释
 * 
 * 时间复杂度：O(m+n)，其中 m, n 分别是 commands 和 obstacles 的长度。
 * 空间复杂度：O(n)，用于存储 obstacleSet 而使用的空间。
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) { 
        // x 轴方向：北 0、东 1、南 0、西 -1
        int[] dx = new int[]{0, 1, 0, -1};
        // y 轴方向：北 1、东 0、 南 -1、西 0
        int[] dy = new int[]{1, 0, -1, 0};
        // 初始的坐标 x、 y，以及方向 di
        int x = 0, y = 0, di = 0;

        // 将每个障碍物的坐标 (x, y) 以 (x+30000) * (2^16) + (y+30000)
        // 编码为 长整型 long 数据，以便它可以放入 集合 Set 数据结构中
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  // 向左转 90 度
                di = (di + 3) % 4;
            else if (cmd == -1)  // 向右转 90 度
                di = (di + 1) % 4;
            else {
                // 走 cmd 步，k 仅用于计数
                for (int k = 0; k < cmd; ++k) {
                    // 预测下一步的位置 (nx, ny)
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    // 编码 (nx, ny) 的阻碍物一维码，看是否存在于阻碍物坐标编码数组中
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        // 若不存在，则更新机器人位置
                        x = nx;
                        y = ny;
                        // 取现有结果与当前欧式距离的平方中的最大值更新结果（贪心）
                        ans = Math.max(ans, x*x + y*y);
                    } else {
                        // 若存在，则说明遇到障碍物，跳出循环
                        break;
                    }
                }
            }
        }

        // 返回结果
        return ans;
    }
}
// @lc code=end

