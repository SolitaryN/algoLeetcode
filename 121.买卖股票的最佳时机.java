/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;

        int minPrice = Integer.MAX_VALUE;

        // 最小值为左边界，如果遇到更小的更新左边界，否则计算差值和 max 进行对比
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                max = prices[i] - minPrice > max?prices[i] - minPrice:max;
            }
        }
        return max;
    }
}
// @lc code=end

