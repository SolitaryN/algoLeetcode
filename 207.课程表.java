/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /*
     * @date 20241008
     * K 神: https://leetcode.cn/problems/course-schedule/solutions/18806/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
     * 使用 BFS 通过 节点入度 + 拓扑排序遍历 判断图中是否有环
     * 
     * @date 20250323
     * 主要就是判断依赖图中是否有环，可以使用 dfs 或 bfs
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        // index 表示课程号
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // 统计节点入度，同时，建立图的邻接表表示
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            // 添加边
            graph.get(cp[1]).add(cp[0]);
        }

        // 获取所有的入度为 0 的节点
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);

        // BFS 进行拓扑排序. BFS TopologySort，这里是拓扑排序而不是逆拓扑排序
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            for(int cur : graph.get(pre)) {
                indegrees[cur]--;
                if(indegrees[cur] == 0){
                    queue.add(cur);
                }
            }
        }
        return Arrays.stream(indegrees).sum() == 0;
    }

    /*
     * @date 20241008
     * dfs 通过监测是否有环
     * 
     * @date 20250323
     * 使用邻接表法表示有向图（这里是顺邻接表，不是逆邻接表，即相邻元素表示下游节点）
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // 构建图
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        for(int[] cp : prerequisites)
            graph.get(cp[1]).add(cp[0]);

        // 标志位，标志节点状态，未访问、其他人访问过、当前遍历路径访问过
        // 未被 DFS 访问过：flag == 0；
        // 已被其他节点启动的 DFS 访问过：flag == -1；
        // 已被当前节点启动的 DFS 访问过：flag == 1。
        int[] flags = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            if(!dfs(graph, flags, i)) return false;
        return true;
    }

    /*
     * 使用 dfs 判断是否有环
     */
    boolean dfs(List<List<Integer>> graph, int[] flags, int i) {
        // 如果在当前遍历路径中被访问过，说明有环
        if(flags[i] == 1) return false;
        // 如果在其他路径中被访问过，没问题
        if(flags[i] == -1) return true;

        // 标记为当前路径访问过
        flags[i] = 1;

        for(Integer j : graph.get(i))
            if(!dfs(graph, flags, j)) return false;

        // 递归结束后，标记为其他路径访问过
        flags[i] = -1; // 退出时，置为 -1，表示验证过没问题

        return true;
    }
}
// @lc code=end
