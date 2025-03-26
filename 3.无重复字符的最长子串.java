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
 * 
 * @date 20250302
 * 主要思想就是滑动窗口，用map记录当前遍历过的字符和下标
 * 但是要注意，更新左边窗口的下标时，要确保left更新为现在窗口内的字符下标
 * 
 * @date 20250326
 * 建议使用这种思路，更加清晰
 */
class Solution {
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) return s.length();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0; // 记录滑动窗口的左端
        int max = 0;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);

            if(map.containsKey(ch)){
                /*
                 * left 只能往前滑动，字符串中可能出现很多重复字符，这些重复字符若在left前（窗口外），此时就是无效字符
                 * 因此不能写成: left = map.get(ch) + 1;  此时如果出现 abcba 就会处理字符串最后的 a 时出错，此时造成 left 往前滑动了
                 * 说人话就是，left只能更新为当前滑动窗口内的index，否则不认为当前滑动窗口内存在字符重复，使用原index
                 */
                left = Math.max(map.get(ch) + 1, left); // 注意 + 1
            }

            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    /*
     * @date 20250302
     * 第二种思路，使用map记录窗口内某个字符的数量
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int res = 0;
        int left = 0, right = 0;
        // 先一直更新窗口右边界
        while (right < s.length()) {
            char c = s.charAt(right);

            // 进行窗口内数据的一系列更新，这里保存某字符的数量
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 如果更新之后发现该字符在窗口内数量大于1，则左侧窗口是要收缩
            //      直到发现该字符没有出现重复，即数量只剩 1
            while (window.get(c) > 1) {
                char temp = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(temp, window.get(temp) - 1);
            }
            // 更新答案
            res = Math.max(res, right - left + 1);

            // 更新右边界
            right++;
        }
        return res;
    }
}
// @lc code=end
