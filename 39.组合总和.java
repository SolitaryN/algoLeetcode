/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> now = new ArrayList<>();

    /*
     * @date 20241009
     * 回溯时，两种选择，选择自己，选择下一个元素，收集的和等于 target 或 大于 target 时返回，也即剪枝操作
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helperDFS(0, candidates, target, 0);
        return ans;
    }

    void helperDFS(int index, int[] candidates,int target, int sum){
        if(sum == target) {
            ans.add(new ArrayList<>(now));
            return;
        }

        if(sum > target || index >= candidates.length)
            return;
        
        // 两种选择，不需要循环: 1、还是选择自己   2、选择下一个
        // 选择自己
        now.add(candidates[index]);
        helperDFS(index, candidates, target, sum + candidates[index]);
        now.remove(now.size() - 1);

        // 选择下一个元素
        helperDFS(index + 1, candidates, target, sum);
    }
}
// @lc code=end

