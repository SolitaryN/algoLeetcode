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

    /**
     * 对于每个元素都当成二叉树的一个节点处理，加入 或 不加入 两种选择
     * @param nums
     * @param index 当前进行选择的元素下标
     * @param ans
     * @param set 当前元素集合
     */
    // 对于nums中的每个元素，都有两个选择，加入结果或者不加入
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

