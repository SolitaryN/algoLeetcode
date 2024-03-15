import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int[] result = new int[2];
    //     for (int i = 0; i < nums.length; i++){
    //         for (int j = i + 1; j < nums.length; j++){
    //             if(nums[i] + nums[j] == target){
    //                 result[0] = i;
    //                 result[1] = j;
    //             }
    //         }
    //     }
    //     return result;
    // }

    // public int[] twoSum(int[] nums, int target) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for(int i = 0; i <= nums.length; ++i){
    //         if(map.containsKey(target - nums[i])){
    //             return new int[]{map.get(target - nums[i]), i}; 
    //         }
    //         map.put(nums[i], i);
    //     }

    //    return new int[0];
    // }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
// @lc code=end

