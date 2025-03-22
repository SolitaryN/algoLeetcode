/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /*
     * @date 20241009
     * 对于每个元素来说都只有两种选择：加、不加
     * 
     * @date 20250322
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helperDfs(nums, 0, ans, new HashSet<>());
        return ans;
    }

    void helperDfs(int[] nums, int index, List<List<Integer>> ans, Set<Integer> set){
        if(index == nums.length){
            ans.add(new ArrayList<>(set));
            return;
        }

        // 如果是加，出递归后需要删除，即回溯
        set.add(nums[index]);
        helperDfs(nums, index + 1, ans, set);
        set.remove(nums[index]);

        // 如果是不加
        helperDfs(nums, index + 1, ans, set);
    }
}
// @lc code=end

