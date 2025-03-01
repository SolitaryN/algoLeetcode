import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

    /*
     * date: 2025/03/01
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> r = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (r.containsKey(nums[i])) {
                return new int[]{r.get(nums[i]), i};
            }

            r.put(target - nums[i], i);
        }

        return new int[0];
    }

}
// @lc code=end

