import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    /*
     * @date 20240925
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3){
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            // i 为锚点，此时如果值大于0，则break
            if(nums[i] > 0) return ans;
            
            // 锚点去重。 就算有 aa 或者 aaa都已经排查过了
            if(i > 0 && nums[i] == nums[i - 1])  continue;
            
            int anchor = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int temp = anchor + nums[L] + nums[R];
                if(temp == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 元素去重。确认答案后，左右都要移动到下一个不相等的元素上
                    while (L < R && nums[L] == nums[L + 1])  ++L;
                    while (L < R && nums[R] == nums[R - 1])  --R;
                    L++;  R--;
                }else if(temp < 0){
                    // 此时负数元素过小，左边右移
                    ++L;
                }else if(temp > 0){
                    // 此时正数元素过大，右边左移
                    --R;
                }
            }
        }
        return ans;
    }

    /*
     * @date 20250302
     * nSum 问题的全部求解。大体思想就是固定n-2个锚点anchors，然后计算2Sum问题，求解
     * https://labuladong.online/algo/practice-in-action/nsum/
     * 解释，这里把问题看成两部分
     *  1）锚点的选择（这里锚点的更新选择不会发生重复）
     *  2) 把nSum问题化解成 (n-1)Sum问题，直到递归到2Sum问题
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        // n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return nSumTarget(nums, 3, 0, 0);
    }

    /* 
     * 注意：调用这个函数之前一定要先给 nums 排序
     * n 填写想求的是几数之和
     * start 从哪个索引开始计算（一般填 0）
     * target 填想凑出的目标和
     */
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case
        if (n == 2) {
            // 双指针那一套操作
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum （加上该轮搜索的锚点）
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++; // 避免重复锚点，放置答案重复
            }
        }
        return res;
    }
}