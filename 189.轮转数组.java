/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    /*
     * @date 20241006
     * 使用备份数组，引入空间复杂度，差
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] copy = new int[len];
        k = k % nums.length;

        for (int i = 0; i < len; i++) {
            copy[(i + k) % len] = nums[i];
        }

        System.arraycopy(copy, 0, nums, 0, len);
    }

    /*
     * @date 20250306
     * leetcode 官方题解
     * https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // 使用 count 记录已经转移的元素个数，因为需要转换多轮，这里不想进行数学推理了，直接记录转移个数即可
        int count = 0;
        for (int start = 0; count < n; ++start) {
            int current = start;
            int prev = nums[start];

            // 每轮停止的条件就是完成一个循环，此时下标回到 start index
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /*
     * @date 20241006
     * 进行数组反转之后，再分批反转就行了
     * 巧解： https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
     * 
     * @date 20250306
     */
    public void rotate1(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /*
     * 对数组元素进行倒置
     */
    public void reverse(int[] nums, int start, int end) {
        for (; start < end; ++start, --end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }
    }
}
// @lc code=end
