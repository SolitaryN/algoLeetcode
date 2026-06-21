/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /*
     * @date 20241011
     * 使用类似于“跳跃游戏2”题目的方法，统计区间的个数即可求解
     * 
     * @date 20250324
     * 核心思想：寻找当前区间内的最大右边界，当遍历到最大边界时，说明当前区间已经找到
     *           保证当前区间的元素不会出现在后面的区间中
     * 
     * 一直更新现有区间的右边界，直到遍历到该右边界，此时认为该区间的满足要求，区间中的字符无处于该区间右边界外的区域（否则此时右边界一定不是现在的位置，会往后更新）。
     */
    public List<Integer> partitionLabels(String s) {
        //保存元素最后出现在字符串当中的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);

        // 注意初始化区间边界的技巧，尽量不要在外面直接初始化为数据中的某个值
        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));

            if (i == right) {
                ans.add(right - left + 1);
                left = right + 1;
            }
        }

        return ans;
    }
}
// @lc code=end

