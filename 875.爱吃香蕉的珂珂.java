/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        // int l = Arrays.stream(piles).sum() / h;  // 进行聚合操作，但是这里求和会越界
        // Arrays.stream(piles).filter(x -> x % 2 == 0).toArray(); // 进行过滤
        // Arrays.stream(piles).map(x -> x * x).toArray(); // 进行映射操作
        // Arrays.stream(piles).sorted().toArray(); // 进行排序操作
        // Arrays.stream(piles).forEach(x -> System.out.println(x));  // 数据处理


        while (l < r) {
            int mid = l + (r - l) / 2;
            if(canEatAll(piles, mid, h)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return r;
    }

    boolean canEatAll(int[] piles, int eat, int time){
        int all = 0;
        for (int i = 0; i < piles.length; i++) {
            all = all + (int)Math.ceil((double)piles[i]/ eat);
        }
        return all <= time;
    }
}
// @lc code=end

