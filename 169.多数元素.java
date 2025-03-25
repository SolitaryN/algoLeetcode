/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     * @date 20241006
     * 排序，由于过半，则中间元素肯定就是
     * 
     * @date 20250325
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
     * @date 20241006
     * hashmap 保存数量
     * 
     * @date 20250325
     * 对比当前数字出现的次数，保存出现次数最多的数字
     */
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > n / 2) {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }

    /*
     * @date 20241006
     * Moore 投票算法，相等加1，不相等减1，
     * 由于一个数字过半，则最终经过一次遍历之后，则最终这个数肯定会大于1
     * 
     * @date 20250325
     */
    public int majorityElement(int[] nums) {
        int count = 0, candidater = 0;

        for (int num : nums) {
            if (count == 0)
                candidater = num;
            
            if (candidater != num)
                count--;
            else 
                count++;
        }

        return candidater;
    }
}
// @lc code=end

