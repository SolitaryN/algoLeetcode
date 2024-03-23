/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> now = new ArrayList<>();

        helperDFS(ans, 0, candidates, now, target, 0);

        return ans;
    }

    void helperDFS(List<List<Integer>> ans, int index, int[] candidates, List<Integer> now, int target, int sum){
        if(sum == target){
            ans.add(new ArrayList<>(now));
            return;
        }else if(sum > target || index >= candidates.length){
            return;
        }

        // 继续选择下标为 index 的数字
        now.add(candidates[index]);
        helperDFS(ans, index, candidates, now, target, sum + candidates[index]);
        now.remove(now.size() - 1);

        // 选择下一个数字，注意，这里还并没有把该数字加入进去，加入该数字的是在函数内完成，防止index越界
        helperDFS(ans, index + 1, candidates, now, target, sum);
    }
}
// @lc code=end

