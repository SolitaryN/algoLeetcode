class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] assi = new int[nums.length];

        int firstPositiveOrZeroIndex  = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0){
                firstPositiveOrZeroIndex = i;
                break;
            }
        }

        if(firstPositiveOrZeroIndex == 0){
            // 此时说明 nums 数组内元素全大于等于0
            for (int i = 0; i < nums.length; i++) {
                assi[i] = nums[i] * nums[i];
            }
        }else if(firstPositiveOrZeroIndex == -1){
            // 此时说明全为负数
            int j = 0;
            for (int i = assi.length - 1; i >= 0; --i) {
                assi[j] = nums[i] * nums[i];
                j++;
            }
        }else{
            // 此时说明 nums 数组内有负数，使用归并算法来解决, 记得保证 0 <= i，和 start < nums.length
            // 第一个分区是 [0, fistPositiveOrZeor)  第二个分区是[firstPositiveOrZero, nums.length)
            int i = firstPositiveOrZeroIndex - 1, start = firstPositiveOrZeroIndex ,end = nums.length;
            int assiIndex = 0;

            while(0 <= i && start < end){
                if(nums[i]*nums[i] <= nums[start] * nums[start]){
                    assi[assiIndex] = nums[i] * nums[i];
                    assiIndex++;
                    i--;
                }else if(nums[i]*nums[i] > nums[start] * nums[start]){
                    assi[assiIndex] = nums[start] * nums[start];
                    assiIndex++;
                    start++;
                }
            }

            // 对剩余部分进行归并
            if(i == -1){
                while(start < end){
                    assi[assiIndex] = nums[start] * nums[start];
                    start++;
                    assiIndex++;
                }
            }

            if(start == end){
                while(i >= 0){
                    assi[assiIndex] = nums[i] * nums[i];
                    i--;
                    assiIndex++;
                }
            }
        }
        return assi;
    }
}