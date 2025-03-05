/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    /*
     * @date 20241005
     * 使用小根堆求第K大的元素，使用大根堆求第K小的元素
     * 
     * @date 20250305
     * 注意大小根堆的区别，然后还是默认的PriorityQueue是小根堆，这个是经典解法，但时间复杂度为 O(nlogn)
     */
    public int findKthLargest1(int[] nums, int k) {
        // 默认是小根堆
        Queue<Integer> queue = new PriorityQueue<>();

        int num = 0;
        for (int i : nums) {
            if (num < k) {
                queue.offer(i);
                num++;
            }else{
                queue.offer(i);
                queue.poll(); // 把最小元素抛弃
            }
        }
        return queue.peek();
    }

    /*
     * @date 20250305 使用二叉快速排序的思想
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcod-2/
     * 这里是官方题解给的，先使用二叉排序寻找 pivot 的坐标，这个坐标其实就是最终左边，显示它为第几小，此时把第k大转换为第n-k+1小，看它们之间的关系，决定对左边还是右边进行递归，知道最后得到答案
     * 时间复杂度为O(n)
     */
    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        // n - k 表示下标，第k大，即第n-k+1小，这里是下标所以没有加1
        return quickselect(_nums, 0, n - 1, n - k);
    }


    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }
}
// @lc code=end

