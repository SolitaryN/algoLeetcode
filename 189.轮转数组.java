class Solution {
    public void rotate(int[] nums, int k) {
        // 先求交换的两个下标
        int[] assi = new int[nums.length];
        for (int i = 0; i < assi.length; i++) {
            assi[i] = nums[i];
        }
        
        int len = nums.length;
        for (int i = 0; i < assi.length; i++) {
            nums[(i + k)%len] = assi[i];
        }
    }

    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public void rotate_b(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] assi = new int[k]; // 用于保存数组后面的 k 个下标连续元素
        for (int i = 0; i < k; i++) {
            assi[k - 1 - i] = nums[len - 1 - i];
        }

        for (int i = 0; i < len - k; i++) {
            nums[len - 1 - i] = nums[len - 1 - i - k];
        }

        for (int i = 0; i < k; i++) {
           nums[i] = assi[i];  
        }
    }


    // 巧解： https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
    public void rotate_c(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}