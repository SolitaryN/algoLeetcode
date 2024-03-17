/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] > target - numbers[i]){
                    break;
                }
                if(target == (numbers[i] + numbers[j])){
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low + 1, high + 1};
            }else if(sum < target){
                ++low;
            }else if(sum > target){
                high--;
            }
        }

        return new int[]{0, 0};
    }
}
// @lc code=end

