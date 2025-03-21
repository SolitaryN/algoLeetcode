/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    /*
     * @20240310
     * 
     * @20250321
     *  暴力解法，合并两个数组，然后找中位数，很垃圾，建议不要用，时间复杂度为O(m+n)
     *  这里空间复杂度为O(m+n)，可以使用两个指针，使用类似归并的策略，找中间值，可以优化到O(1)
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] all = new int[total];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                all[k++] = nums1[i++];
            } else {
                all[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            all[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            all[k++] = nums2[j++];
        }

        if(total % 2 == 1){
            return all[total/2];
        }else{
            return (all[total/2] + all[total/2 -1])/2.0;
        }
    }

    /*
     * @20250321
     * 把该问题化为寻找第k小的数
     * 这里就是找(m+n)/2的数，就可以使用二分查找，时间复杂度为O(log(m+n))
     * 讲的不错： https://www.bilibili.com/video/BV1z54y1b7wb/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if((m + n) % 2 == 1){
            // 如果是奇数，就找第(m+n)/2 + 1个数
            return helperFind(nums1, 0, nums2, 0, (m + n)/2 + 1);

        }else{
            // 如果是偶数，就找第(m+n)/2 和 (m+n)/2 + 1个数，然后求平均值
            int left = helperFind(nums1, 0, nums2, 0, (m + n)/2);
            int right = helperFind(nums1, 0, nums2, 0, (m + n)/2 + 1);
            return (left + right) / 2.0;
        }
    }

    /*
     * s1Idx 和 s2Idx 表示两个数组中剩余未处理数据的起始下标
     * kth 表示要找第kth个数
     */
    int helperFind(int[] nums1, int s1Idx, int[] nums2, int s2Idx, int kth){
        // 出递归的条件，如果一个数组已经全部处理完了，就直接返回另一个数组的第kth个数
        if(nums1.length == s1Idx) return nums2[s2Idx + kth - 1];
        if(nums2.length == s2Idx) return nums1[s1Idx + kth - 1];

        // 如果 kth == 1，就直接返回两个数组中最小的那个数
        if(kth == 1) return Math.min(nums1[s1Idx], nums2[s2Idx]);

        // 加 kth/2，这样中间元素肯定不会被跳过
        int idx1 = Math.min(s1Idx + kth/2, nums1.length); // 防止小数组下标越界
        int idx2 = Math.min(s2Idx + kth/2, nums2.length); // 防止小数组下标越界

        // idx1 和 idx2 表示开始位置元素，天生就多加了 1，所以对比时要 -1
        if(nums1[idx1 - 1] < nums2[idx2 - 1]){
            // 如果nums1的第k/2个元素小于nums2的第k/2个元素，就可以把nums1的前k/2个元素丢掉
            // 寻找第 kth - k/2 个元素
            return helperFind(nums1, idx1, nums2, s2Idx, kth - (idx1 - s1Idx));
        }else{
            return helperFind(nums1, s1Idx, nums2, idx2, kth - (idx2 - s2Idx));
        }
    }
}
// @lc code=end

