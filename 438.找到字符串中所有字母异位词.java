/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /*
     * @date 20240925
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (pLen > sLen) return Collections.emptyList();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            Character ch = p.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> ans = new ArrayList<>();

        // 这里使用 [left，right) 表示窗口，左闭右开
        while (right < sLen) {
            // 窗口右移扩大更新数据
            Character ch = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            // Java踩雷， 要用equals()进行判断！！！
            // Map中存放的value的类型是Integer，缓存区的区间范围是[-128, 127]，就不可以用 == 判断了！！！
            if(need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) valid++; // 窗口内某字符数量等于所需字符数量
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= pLen) {
                // 当窗口符合条件时，把起始索引加入 res，收割结果
                if (valid == need.size())
                    ans.add(left);

                Character d = s.charAt(left);
                left++;

                // 窗口缩小时，进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

