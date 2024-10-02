/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @date 一开始想到滑动窗口，然后敲完发现k可以是负值，然后想到了动态规划，然后就是放弃看题解了
 * 该题使用前缀和 + 哈希表优化求解
 * 前缀和 就是  从开头元素都现在元素的和，如果到现在的和刚好等于 K + 某一个前缀和 则收割结果
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int pre = 0; // 记录每次遍历的前缀和

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 前缀和为 0 默认有一个

        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }
}
// @lc code=end

