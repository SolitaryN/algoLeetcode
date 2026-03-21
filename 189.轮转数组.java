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
    public void rotate3(int[] nums, int k) {
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
    public void rotate(int[] nums, int k){
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

    /**
     * 20260321
     * 这里尽量不要使用这种来 reverse，因为要再加边界条件
     */
    public void reverse1(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        for (; start <= mid; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }


    /**
     * 20260321
     * 这里交换数据之所以用到了prevVal，是因为该值保存的不是 nums[curr] 的值，而是上一个被挤占走到元素的值，这里只是初始化的时候，被赋值了 nums[curr]，其实也是被最后一个迁移的元素挤占走了
     * 注意终止条件，这里每次操作的不是 curr 元素，而是 target元素
     * 另外这里使用 do...while是为了更好的使用 curr 来进行循环的终止
     * 这里可以看到，如果 k 是一个 质数，则只需要循环一次就能把所有元素移动好
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int count = gcd(k, nums.length);
        for (int start = 0; start < count; start++) {
            int prevVal = nums[start], curr = start;
            do {
                int target = (curr + k) % nums.length;
                int temp = nums[target];
                nums[target] = prevVal;
                prevVal = temp;
                curr = target;
            } while (curr != start);
        }
    }

    // 求最大公约数算法，欧几里得算法，另外：最小公倍数通过两数乘积除两数最大公约数可得
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
// @lc code=end
