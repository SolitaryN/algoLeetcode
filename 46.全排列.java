/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> now = new ArrayList<>();

        int[] used = new int[nums.length];

        helper(ans, now, used, nums, 0);

        return ans;
    }

    void helper(List<List<Integer>> ans, List<Integer> now, int[] used, int[] nums, int count){
        if(count == nums.length){
            ans.add(new ArrayList<>(now)); // 注意这里添加的不是 now 数组本身，而是它的副本
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(used[i] == 0){
                now.add(nums[i]);
                used[i] = 1;

                helper(ans, now, used, nums, count + 1);

                used[i] = 0;
                now.remove(now.size() - 1);
            }else{
                continue;
            }
        }
    }
}
// @lc code=end

