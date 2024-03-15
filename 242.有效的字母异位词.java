/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    // public boolean isAnagram(String s, String t) {
    //     if(s.length() != t.length())
    //         return false;

    //     Map<Character, Integer> map = new HashMap<>();
    //     Map<Character, Integer> map_t = new HashMap<>();
    //     char[] s_char = s.toCharArray();
    //     char[] t_char = t.toCharArray();

    //     for(Character c : s_char ){
    //         if(map.containsKey(c)){
    //             map.put(c, map.get(c) + 1);
    //         }else{
    //             map.put(c, 1);
    //         }
    //     }

    //     for(Character c : t_char ){
    //         if(map_t.containsKey(c)){
    //             map_t.put(c, map_t.get(c) + 1);
    //         }else{
    //             map_t.put(c, 1);
    //         }
    //     }

    //     if(map.size() != map_t.size())
    //         return false;

    //     for(Character key : map.keySet()){
    //         if(!map_t.containsKey(key))
    //             return false;
    //         if(map.get(key) != map_t.get(key)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    public boolean isAnagram(String s, String t) {
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

    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     Map<Character, Integer> table = new HashMap<Character, Integer>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         table.put(ch, table.getOrDefault(ch, 0) + 1);
    //     }
    //     for (int i = 0; i < t.length(); i++) {
    //         char ch = t.charAt(i);
    //         table.put(ch, table.getOrDefault(ch, 0) - 1);
    //         if (table.get(ch) < 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}

// @lc code=end

