/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestConsecutive1(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        Arrays.sort(nums);

        int longest = 0;
        int pre = nums[0];
        int now = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == pre){
                continue;
            }
            if(nums[i] == (pre + 1)){
                now++;
            }
            if(nums[i] > pre + 1){
                if(now > longest){
                    longest = now;
                }
                now = 1;
            }
            pre = nums[i];
        }

        if(now > longest){
            longest = now;
        }
        return longest;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxNum = 0;
        for(int i : nums){
            if(!map.containsKey(i)){
                int left = map.getOrDefault(i - 1, 0);
                int right = map.getOrDefault(i + 1, 0);
                int current = left + right + 1;
                if(current > maxNum){
                    maxNum = current;
                }
                map.put(i - left, current);
                map.put(i + right, current);
                map.put(i, current);
            }
        }
        return maxNum;
    }

    public int longestConsecutive3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int longest = 0;
        for(int i : set){
            if(set.contains(i - 1)){   // 找到连续序列的开头元素，才往下进行
                continue;
            }
            int current = i;
            int cur_long = 1;
            while (set.contains(current + 1)) {
                cur_long++;
                current += 1;
            }

            longest = Math.max(cur_long, longest);
        }

        return longest;
    }

    /*
     * @date 20240731
     * @date 20250301
     * @desc 时间复杂度和空间复杂度都是 O(n)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); // 去重
        Arrays.stream(nums).forEach(ele -> set.add(ele));

        int longest = 0;
        for (int i : set) {
            // 开始进行下一步之前，必须确保元素是序列的开头
            if (set.contains(i - 1)) {
                continue;
            }

            int currLong = 1;
            int head = i;
            while (set.contains(head + 1)) {
                currLong += 1;
                head += 1;
            }
            longest = Math.max(longest, currLong);
        }
        return longest;
    }
}
// @lc code=end

