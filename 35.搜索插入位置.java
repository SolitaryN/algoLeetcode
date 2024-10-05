class Solution {
    /*
     * @date 20241004
     * 这里需要注意mid的计算方式，下面写法不容易造成超出表示范围的情况
        int mid = left + (right - left) / 2; // 相当于 (left + right)/2
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2; // 相当于 (left + right)/2
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return left;
    }
}
