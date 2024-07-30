/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> map_s = new HashMap<>();
        count(s, map_s);
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map_s.put(ch,  map_s.getOrDefault(ch, 0) - 1);
            if(map_s.get(ch) < 0)
                return false;
        }

        return true;
    }

    public void count(String s, Map<Character, Integer> res){
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for(char ch : s.toCharArray()) {
            sArray[ch - 'a'] += 1;
        }

        for(char ch : t.toCharArray()) {
            tArray[ch - 'a'] += 1;
        }

        for (int i = 0; i < tArray.length; i++) {
            if (tArray[i] != sArray[i]) {
                return false;
            }
        }
        return true;
    }
}

// @lc code=end

