class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, middle = (start + end)/2;

        while(start <= end){
            if(nums[middle] > target){
                end = middle - 1;
            }else if(nums[middle] < target){
                start = middle + 1;
            }else if(nums[middle] == target){
                return middle;
            }

            middle = (start + end)/2;
        }
        return -1;
    }
}
