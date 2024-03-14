class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length, mid = left + (right - left)/2;

        while(left < right){
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
                mid = left + (right - left) / 2;
            }else if(nums[mid] < target){
                left = mid + 1;
                mid = left + (right - left) / 2;
            }
        }

        // 此时 left == right，进行最终判断
        if(nums[left] >= target)
            return left;
        else
            return left + 1;
    }
}
