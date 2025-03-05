/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /*
     * @date 20240730
     * 
     * @date 20250305
     * 这题使用单调递增栈来解决
     * 以当前单调递增栈中栈顶下标的高作为矩形的高，然后寻找该高度时最大的宽度，即在单调递增栈中该元素左边的元素和当前遍历的违反了单调性的index的下标，相减再减1即为最大宽。
     * 
     * 单调栈可以帮助快速找到每个柱子左右两侧第一个比它矮的柱子，从而计算以该柱子为高的最大矩形面积。
     */
    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 创建加了两个哨兵的数组，方便进行边界处理
        int[] newHeight = new int[heights.length + 2];
        newHeight[0] = 0;
        newHeight[newHeight.length - 1] = 0;
        System.arraycopy(heights, 0, newHeight, 1, heights.length);

        int maxArea = 0;
        for (int i = 0; i < newHeight.length; i++) {
            // 当前元素违反了单调性时，会收割结果，如果该元素为最后的哨兵元素，则全部会出栈
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int mid = stack.pop();

                int width = i - stack.peek() - 1;
                int height = newHeight[mid];
                maxArea = Math.max(width * height, maxArea);
            }

            stack.push(i); // 单调递增栈
        }

        return maxArea;
    }

    /*
     * @date 20250305
     * 不使用数组来引入哨兵，这里当到固定位置时，特殊处理，最后的哨兵高度为0，保证栈中元素都被处理
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        int n = heights.length;
        for (int i = 0; i <= heights.length; i++) {
            // 末尾设置哨兵，哨兵高度为0，保证栈中元素全部出列
            int h = (i == n) ? 0 : heights[i];

            // 当前元素违反了单调性时，会收割结果，如果该元素为最后的哨兵元素，则全部会出栈
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int mid = stack.pop();

                // 这里需要对最左边的高进行特殊处理，因为它的左边已经没有元素，这里赋值-1，可自己举例验证
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                int height = heights[mid];
                max = Math.max(width * height, max);
            }

            stack.push(i); // 单调递增栈
        }

        return max;
    }
}
// @lc code=end

