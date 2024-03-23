class Solution {
    public int search1(int[] nums, int target) {
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

    public int search(int[] nums, int target) {
        if(nums.length == 0) 
            return -1;

        int l = 0, r = nums.length - 1;
        int middle = (l + r) / 2;

        while(l <= r){
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                l = middle + 1;
            }else if(nums[middle] > target){
                r = middle - 1;
            }
            middle = (l + r) / 2;
        }

        return -1;
    }
}
