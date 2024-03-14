class Solution {
    public int maxArea(int[] height) {
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

    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int max = (right - left) * (Math.min(height[left], height[right]));

        while (left != right) {
            if (height[left] < height[right]) { // 左边的小，移动左边有可能增大面积
                left++;
                int temp = (right - left) * (Math.min(height[left], height[right]));
                if (temp > max)
                    max = temp;
            } else {
                right--;
                int temp = (right - left) * (Math.min(height[left], height[right]));
                if (temp > max)
                    max = temp;
            }
        }

        return max;
    }
}