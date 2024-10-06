/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * @date 20241006
     * 先排序，之后考虑区间的不同情况，进行处理就行
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0], nextEnd = intervals[i][1];
            if (nextStart > end) {
                ans.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            } else if (end >= nextStart && nextEnd >= end) {
                end = nextEnd;
            }
        }
        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end

