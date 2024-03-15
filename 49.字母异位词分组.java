/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[][] ans = new int[strs.length][26];

        int j = 0;
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                ans[j][s.charAt(i) - 'a'] += 1;
            }
            j++;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < ans.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                sb.append(ans[i][k] + 'a');
                sb.append(ans[i][k]);
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(strs[i]);
            map.put(sb.toString(), list);
        }

        return new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            String key = new String(sChars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(sChars.toString(), list);
        }

        return new ArrayList<>(map.values());
    }

}
// @lc code=end

