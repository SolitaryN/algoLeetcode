/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if((m + n) % 2 == 1){
            return helperFind(nums1, 0, nums2, 0, (m + n)/2 + 1);
        }else{
            int left = helperFind(nums1, 0, nums2, 0, (m + n)/2);
            int right = helperFind(nums1, 0, nums2, 0, (m + n)/2 + 1);
            return (left + right) / 2.0;
        }
    }

    int helperFind(int[] nums1, int i, int[] nums2, int j, int kth){
        // 把小数组放前面方便处理
        if(nums1.length - i > nums2.length - j){
            return helperFind(nums2, j, nums1, i, kth);
        }

        // 此时就不用在 nums1中查找了，因为已经没有元素可以用了
        if(nums1.length == i){
            return nums2[j + kth - 1];
        }
        if(kth == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        // 上述是出递归的条件

        // idx1 和 idx2 表示中间元素的下一个元素，所以说对比的时候要 -1 
        // 确定对比下标的时候，都加 kth/2 就行，这样做中间的元素肯定不会被跳过，因为这样做顶多是右边比左边多一个数
        int idx1 = Math.min(i + kth/2, nums1.length); // 防止小数组下标越界
        int idx2 = j + kth/2;

        if(nums1[idx1 - 1] < nums2[idx2 - 1]){
            return helperFind(nums1, idx1, nums2, j, kth - (idx1 - i));
        }else{
            return helperFind(nums1, i, nums2, idx2, kth - (idx2 - j));
        }
    }
}
// @lc code=end

