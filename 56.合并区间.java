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
     * 先按照各个子区间的开头进行子区间的排序
     *  之后考虑相邻子区间之间的可能出现的 3 种情况，分别进行处理就行
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        int currStart = intervals[0][0], currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0], nextEnd = intervals[i][1];

            if (nextStart > currEnd) {
                // 第一种情况：子区间之间没有任何重合
                ans.add(new int[]{currStart, currEnd});
                currStart = nextStart;
                currEnd = nextEnd;
            } else if (currEnd >= nextStart && nextEnd >= currEnd) {
                // 第二种情况：子区间之间交叉
                currEnd = nextEnd;
            } else if (currEnd <= nextEnd) {
                // 第三种情况：curr子区间包含 next子区间，不做任何更新
            }
        }
        // 最后不要忘了收割剩余的最后一个区间
        ans.add(new int[]{currStart, currEnd});

        // toArray 函数需要指定转换的数组类型，这里指定类型就行，否则会默认转换成 Object[]
        return ans.toArray(new int[0][0]);
    }
}
// @lc code=end

