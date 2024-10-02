class Solution {
    /*
     * @date 20240924
     *  本质上就是贪心算法，每次移动底边变短，所有每次移动左右柱子，保证最高的柱子不移动
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (right > left) {
            int cur = Math.min(height[left], height[right]) * (right - left);
            max = max < cur ? cur : max;

            if(height[right] > height[left]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int max = (right - left) * (height[left] > height[right] ? height[right] : height[left]);

        while (left != right) {
            if (height[left] < height[right]) { // 左边的小，移动左边有可能增大面积
                left++;
                int temp = (right - left) * (height[left] > height[right] ? height[right] : height[left]);
                if (temp > max)
                    max = temp;
            } else {
                right--;
                int temp = (right - left) * (height[left] > height[right] ? height[right] : height[left]);
                if (temp > max)
                    max = temp;
            }
        }

        return max;
    }
}