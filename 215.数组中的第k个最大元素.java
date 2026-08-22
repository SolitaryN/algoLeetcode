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
     * 
     * @date 20250328
     */
    public int findKthLargest3(int[] nums, int k) {
        // 默认是小根堆
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);

            // 把最小元素抛弃
            if (queue.size() > k) {
                queue.poll();
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
    public int findKthLargest2(int[] _nums, int k) {
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


    /**
     * @date 20260818
     * 更加直观的写法
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 第k大 → 升序数组中下标 n-k 的元素
        int targetIndex = n - k;
        return quickSelect(nums, 0, n - 1, targetIndex);
    }

    /**
     * 在 [left, right] 区间内寻找下标 targetIndex 的元素
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     * @param targetIndex 需要找到的全局下标
     * @return 目标数值
     */
    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        // 区间只剩一个元素，直接返回
        if (left == right) {
            return nums[left];
        }

        // 分区：返回分割点 j，[left,j] ≤ pivot，[j+1,right] ≥ pivot
        int partitionPos = partition(nums, left, right);

        if (targetIndex <= partitionPos) {
            // 目标落在左区间 [left, partitionPos]
            return quickSelect(nums, left, partitionPos, targetIndex);
        } else {
            // 目标落在右区间 [partitionPos+1, right]
            return quickSelect(nums, partitionPos + 1, right, targetIndex);
        }
    }

    /**
     * 荷兰国旗双向分区（快排经典 do-while 写法）
     * 选定 nums[left] 作为pivot
     * 返回分割位置 pos
     * [l, pos] ≤ pivot
     * [pos+1, r] ≥ pivot
     */
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l - 1;
        int j = r + 1;

        while (i < j) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i < j) {
                // 交换左右不符合条件元素
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return j;
    }
}
// @lc code=end
