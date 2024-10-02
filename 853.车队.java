/*
 * @lc app=leetcode.cn id=853 lang=java
 *
 * [853] 车队
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    public int carFleet1(int target, int[] position, int[] speed) {
        if(position.length == 1){
            return 1;
        }

        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < combine.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        // 下面两种排序方法的写法都一样
        // Arrays.sort(combine, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o2[0] - o1[0];  // 倒序排列
        //     }
        // });
        Arrays.sort(combine, (o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < combine.length; i++) {
            double currTime = (double)(target - combine[i][0]) / combine[i][1];

            if(!stack.isEmpty() && currTime <= stack.peek()) {
                continue;
            }else{
                stack.push(currTime);
            }
        }
        return stack.size();
    }

    public int carFleet2(int target, int[] position, int[] speed) {
        if(position.length == 1){
            return 1;
        }

        int[][] combine = new int[position.length][2];
        for (int i = 0; i < combine.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        // 从大到小排序,倒序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        // queue.addAll(combine); // 语法错误不可这样用，combine不是Collection类型的子类
        for (int i = 0; i < combine.length; i++) {
            queue.add(combine[i]);
        }

        int ans = 1; // 肯定已经有了一个车队
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            while (!queue.isEmpty()) {
                int[] next = queue.poll();
                double currTime = (double) (target - curr[0]) / curr[1];
                double nextTime = (double) (target - next[0]) / next[1];
                if(currTime >= nextTime){
                    continue;  // 追上前面的车之后，该车速度变为前车速度，所以这里直接continue
                }else{
                    curr = next;
                    ans++;
                }
            }
        }
        return ans;
    }


    /*
     * @date 20240817
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        int[][] comb = new int[N][2];
        for (int i = 0; i < N; i++) {
            comb[i][0] = position[i];
            comb[i][1] = speed[i];
        }
        Arrays.sort(comb, (o1, o2) -> o2[0] - o1[0]);

        Stack<Double> stack  = new Stack<>();
        for (int i = 0; i < N; i++) {
            double currTime = ((double)target - comb[i][0]) / comb[i][1];
            if (!stack.isEmpty() && stack.peek() >= currTime) {
                continue;
            } else {
                stack.push(currTime);
            }
        }
        return stack.size();
    }

}
// @lc code=end

