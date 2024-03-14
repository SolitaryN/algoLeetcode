import java.util.Arrays;

class Solution {
    public int trap(int[] height) { // 自己写的，贼烂，懒得看
        int left = 0, right = height.length - 1;
        int sum = 0;

        while (left < right) { // 该方法是一个一个的去找积水区间
            int black = 0; // 记录区间内黑色方块的面积
            int block_right = left + 1; // 记录积水的右柱
            int secMax = left + 1; // 记录区间右边界的次高

            while (block_right <= right && height[left] > height[block_right]) {// 找到第一个比左边高或者相等高度的柱子，或者次高的柱子
                if (height[secMax] < height[block_right])
                    secMax = block_right;
                block_right++; // 一直往右边去找区间的右边界
            }

            if (block_right == right + 1 && height[left] > height[block_right - 1]) // 如果区间的左边界是最高的，此时寻找右边界就一直到数组末尾了
                block_right = secMax; // 此时，区间的右边界就是 left 到数组末尾所有柱子的最高值

            for (int i = left + 1; i < block_right; i++)
                black = black + height[i]; // 计算区间的黑色方块数量/面积

            sum = sum + (block_right - left - 1) * Math.min(height[left], height[block_right]) - black;

            left = block_right; // 更新左边界，继续寻找下一个积水区间
        }
        return sum;
    }

    public int trap2(int[] height) { // 该方法超出时间限制
        int sum = 0;

        for (int i = 1; i <= height.length - 2; i++) { // 第一根柱子和最后一根柱子肯定不能装水，同时如果该柱子比左高和右高其中任意一个高的话，也不能存水
            int leftMax = Arrays.stream(height, 0, i).max().getAsInt();
            int rightMax = Arrays.stream(height, i + 1, height.length).max().getAsInt();
            if (height[i] < leftMax && height[i] < rightMax)
                sum = sum + Math.min(rightMax, leftMax) - height[i];
        }

        return sum;
    }

    public int trap3(int[] height) { // 用动态规划，提前存储左边最大值和右边最大值
        int sum = 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) { // 第一根和最后一根肯定不积水
            sum = sum + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }

    public int trap4(int[] height) { // 官方題解，在动态规划的基础之上，使用双指针策略
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) { // 如果出现了这种情况，一定有 leftMax < rightMax，而且此时  height[right] == rightMax
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}