/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

import static java.lang.Math.negateExact;

import java.util.HashMap;
import java.util.Map;

/*
 * 这题就是典型的滑动窗口类题目，一般来说难度略高，解法框架如下：
 *     int left = 0, right = 0;                    
 *     
 *     while (right < nums.size()) {
 *         // 增大窗口
 *         window.addLast(nums[right]);
 *         right++;
 *         
 *         while (window needs shrink) {
 *             // 缩小窗口
 *             window.removeFirst(nums[left]);
 *             left++;
 *         }
 *     }
 */


class Solution {
    /*
     * @date 20250327
     * 经典滑动窗口解决
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;  // 记录是否凑巧需覆盖字符串的所有字符

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 窗口右移，扩大
            char cr = s.charAt(right);
            right++;
            if (need.containsKey(cr)) {
                // 窗口内数据更新
                window.put(cr, window.getOrDefault(cr, 0) + 1);
                if (window.get(cr).equals(need.get(cr))) {
                    valid++;
                }
            }

            // 判断窗口是否收缩，左移（收缩时机，包含需覆盖字符串的所有字符）
            while (valid == need.size()) {
                // 更新最小覆盖子串，right 已在前面 +1，不需要 right - left +1，左闭右开
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                
                char cl = s.charAt(left);
                left++; // 缩小窗口
                if (need.containsKey(cl)) {
                    // 窗口内数据更新，这里一定要用 equals 方法判断，因为是 Integer
                    if (window.get(cl).equals(need.get(cl))) {
                        valid--; // 如果相等，移出后，有效数减 1
                    }
                    window.put(cl, window.get(cl) - 1);
                }                    
            }

        }

        // 返回最小覆盖子串，如果不包含，则返回 ""
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    /*
     * @date 20250328
     *  window 里面保存很多冗余数据，只需要保存需要的字符即可，建议使用上面的写法
    */
    public String minWindow1(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 窗口右移
            Character ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (window.get(ch).equals(need.getOrDefault(ch, 0))) {
                valid++;
            }
            right++;

            // 窗口左移，有效时
            while (valid == need.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                Character cl = s.charAt(left);
                left++;

                window.put(cl, window.get(cl) - 1);
                if(window.get(cl) == 0) window.remove(cl);
                if (window.getOrDefault(cl, 0) < need.getOrDefault(cl, 0)) {
                    valid--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
// @lc code=end

