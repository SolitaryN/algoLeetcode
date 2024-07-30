/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }

        return  -1;
    }

    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid){
                    count++;
                }
            }

            if(count > mid){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return res;
    }
}
// @lc code=end

