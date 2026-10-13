class Solution {
    /*
     * @date 20240924
     * 本质上就是贪心算法
     * 每次移动底边变短，所有每次移动左右柱子，保证最高的柱子不移动
     * 不能一眼就知道是这样做，要通过数学反证法才能把握要点。
     * 
     * @date 20250301
     * 如果移动较低一边，该边可能会变高，可能使得水面高度升高而面积变大，
     * 如果移动较高一边，该边可能升高或减小，但水面高由最低柱子控制，
     * 水面的高度无论如何都会减小或保持不变，不可能使水的面积变得更大。
     * 
     * 这题真正的精髓是缩减搜索空间的搜索策略：
     * https://leetcode.cn/problems/container-with-most-water/solutions/94102/on-
     * shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu
     * 具体来说，对于每一次移动柱子时，都会排除所有较低柱子与其它柱子组成的水面面积，
     * 只可能更小，不可能更大，因为宽减小，水面高度又受较低柱子影响，此时直接选择移动较低柱子就行。
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (right > left) {
            int h = Math.min(height[right], height[left]);
            ans = Math.max(h * (right - left), ans);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }

}