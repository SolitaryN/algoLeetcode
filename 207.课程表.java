/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /*
     * @date 20241008
     * K 神: https://leetcode.cn/problems/course-schedule/solutions/18806/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
     * 使用 BFS 通过 节点入度 + 拓扑排序遍历 判断图中是否有环
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        // arraylist 的 index 表示课程号
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        // 统计节点入度，同时，建立图的邻接表表示
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            // 添加边
            adjacency.get(cp[1]).add(cp[0]);
        }

        // 获取所有的入度为 0 的节点
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);

        // BFS 进行拓扑排序. BFS TopSort. ，这里是拓扑排序而不是逆拓扑排序
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

    /*
     * 20241008
     * dfs 通过监测是否有环
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建图
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);

        // 标志位，标志节点状态，未访问、其他人访问过、当前遍历路径访问过
        // 未被 DFS 访问：i == 0；
        // 已被其他节点启动的 DFS 访问：i == -1；
        // 已被当前节点启动的 DFS 访问：i == 1。
        int[] flags = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false;
        return true;
    }

    boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;

        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j)) return false;
        flags[i] = -1; // 退出时，置为 -1，表示验证过没问题

        return true;
    }
}
// @lc code=end
