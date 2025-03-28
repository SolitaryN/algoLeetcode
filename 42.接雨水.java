import java.util.Arrays;

class Solution {
    /*
     * @date 20250328
     *  用动态规划，提前存储左边最大值和右边最大值，时间复杂度 O(n)，空间复杂度 O(n)
     *      使用两个数组，分别存储对于 height[i]，此时 i 左边和右边的最大值
     *      这里动态规划是自底向上的，左边和右边的最大值是从下往上推导的
     * https://labuladong.online/algo/frequency-interview/trapping-rain-water/
     * 
     *  water[i] = min(
     *          # 左边最高的柱子
     *          max(height[0..i]),
     *          # 右边最高的柱子
     *          max(height[i..end])
     *      )  -  height[i]
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        // 初始化对于每个柱子 i，左边的最大值
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // 初始化对于每个柱子 i，右边的最大值
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int sum = 0;
        // 第一根和最后一根不积水
        for (int i = 1; i < len - 1; i++) {
            sum = sum + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }

    /*
     * @date 20250328
     *  官方題解，在动态规划的基础之上，使用双指针策略
     *  其实是同样的思路，只是没有使用额外的空间来存储左右两边的最大值
     */
    public int trap2(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                // 一定有 leftMax < rightMax，而且此时 height[right] == rightMax
                sum += leftMax - height[left];
                ++left;
            } else {
                sum += rightMax - height[right];
                --right;
            }
        }
        return sum;
    }

    /*
     * @date 20250328
     *  思路和上面一样，但是没有使用动态规划提前保存左右两边的最大柱子，超出时间限制
     *   计算左右两边的最大柱子，使用了 O(n^2) 的时间复杂度
     */
    public int trap3(int[] height) { // 
        int sum = 0;

        for (int i = 1; i <= height.length - 2; i++) {
            int leftMax = Arrays.stream(height, 0, i).max().getAsInt();
            int rightMax = Arrays.stream(height, i + 1, height.length).max().getAsInt();
            if (height[i] < leftMax && height[i] < rightMax)
                sum = sum + Math.min(rightMax, leftMax) - height[i];
        }

        return sum;
    }
}