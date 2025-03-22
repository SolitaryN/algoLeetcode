/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /*
     * @date 20241009
     * 回溯，这里需要记录是否已经包含，使用 set
     * 
     * @date 20250322
     * 这里如果使用类型为集合的now来记录，会导致回溯时需要复制now，此时可能添加的数组无序，所以使用list
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        backtrack(ans, now, used, nums, 0);
        return ans;
    }

    void backtrack(List<List<Integer>> ans, List<Integer> now, Set<Integer> used, int[] nums, int count){
        if(count == nums.length){
            // 回溯算法收割结果，写入now数组的副本
            ans.add(new ArrayList<>(now)); 
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used.contains(nums[i])){
                now.add(nums[i]);
                used.add(nums[i]);

                backtrack(ans, now, used, nums, count + 1);

                used.remove(nums[i]);
                now.remove(now.size() - 1);
            }
        }
    }
}
// @lc code=end

