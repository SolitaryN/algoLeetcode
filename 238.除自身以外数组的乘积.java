/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int flag_zero = 0;

        int sum = 1;
        for (int i = 0; i < ans.length; i++) {
            if(nums[i] != 0){
                sum = sum * nums[i];
            }else{
                flag_zero += 1;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if(flag_zero == 1 && nums[i] != 0){
                ans[i] = 0;
            }else if(flag_zero == 1 && nums[i] == 0){
                ans[i] = sum;
            }
            if(flag_zero == 0){
                ans[i] = sum / nums[i];
            }
            if(flag_zero >= 2)
                ans[i] = 0;
        }

        return ans;

    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        
        int[] L = new int[length];
        int[] R = new int[length];
        int[] ans = new int[length];

        L[0] = 1;
        R[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
            R[length - i - 1] = R[length - i] * nums[length - i];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = L[i] * R[i];
        }

        return ans;
    }
}
// @lc code=end

