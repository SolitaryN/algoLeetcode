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
    public int trap2(int[] height) {
        int len = height.length;
        // leftMax[i] 和 rightMax[i] 表示柱子 i 包含自身高度，左右两边的最高柱子大小，方便计算水大小
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
     * 
     *  这里通过 lmax 和 rmax 进行对比，判断左右两边谁的水平面限制出现，也就是较小值的出现。
     *  此时就从先出现限制的那边进行计算。
     * 
     *  另外这里退出循环的边界条件也有讲究，这里按照直觉，其实是 l<=r 不满足时才退出循环，但是其实算法执行到 l==r 这里时，因为每次都是移动较低的边界，此时这个位置其实是数组中最高柱子的所在地，这里不会贡献存储水，所以边界条件也可以写为 l < r，但建议还是按照直觉的 l<=r
     */
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0;
        int sum = 0;

        while (l <= r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax <= rmax) {
                sum = sum + (lmax - height[l]);
                l++;
            } else {
                sum += (rmax - height[r]);
                r--;
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