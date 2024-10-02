/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

/**
 * the better answer
 * @date 20240925
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if(map.containsKey(ch)){
                // left 只能往前滑动，因字符串中可能出现很多重复字符，这些重复字符若在left前（窗口外），此时就是无效字符
                // 所以说下面不能写成: left = map.get(ch) + 1;  此时如果出现: abba 就会出错
                // 说人话就是，left只能更新为窗口内的index，否则就不任务重复，使用原index
                left = Math.max(map.get(ch) + 1, left);
            }

            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
// @lc code=end
