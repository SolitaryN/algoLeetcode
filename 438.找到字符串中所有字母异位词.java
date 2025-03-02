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
     * 
     * @date 20250301
     *  下面这是解决该类窗口滑动问题的模板。
     *  使用 need 记录需求字符频率，使用 window 记录当前包含需求字符的窗口状况
     *  使用 valid 记录合法性
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

        // 这里使用 [left，right) 表示窗口，左闭右开，因为right的数据获取后就++了
        while (right < sLen) {
            // 窗口右移扩大更新数据
            Character ch = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            // Java踩雷， 要用equals()进行判断！！！
            // Map中存放的value的类型是Integer，缓存区的区间范围是[-128, 127]，就不可以用 == 判断了！！！
            if(need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                // 窗口内某字符数量等于所需字符数量
                if (window.get(ch).equals(need.get(ch))) valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left == pLen) {
                // 当窗口符合条件时，把起始索引加入 res，收割结果
                if (valid == need.size())
                    ans.add(left);

                Character leftCh = s.charAt(left);
                left++;

                // 窗口缩小时，更新窗口内数据状态
                if (need.containsKey(leftCh)) {
                    if (window.get(leftCh).equals(need.get(leftCh)))
                        valid--;
                    window.put(leftCh, window.get(leftCh) - 1);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

