/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                // left 只能往前滑动，不会往后滑动，因为字符串当中可能出现很多重复字符，这些重复字符可能在left前面，此时就是无效字符
                // 所以说下面不能写成: legt = map.get(s.charAt(i)) + 1;  此时如果出现: abba 就会出错
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            max = i - left + 1 > max ? i - left + 1 : max;
        }

        return max;
    }
}

class Solution2 {
    // input: aab
    public int lengthOfLongestSubstring(String s) {
        Integer maxLen = 0;
        Integer removeStart = 0;
        if(s == null){
            return maxLen;
        }   

        HashMap<Character, Integer> myMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if(myMap.get(ch) == null){
                myMap.put(ch, i);
            }else{
                if(myMap.size() > maxLen)
                    maxLen = myMap.size();
                
                Integer index = myMap.get(ch);
                for (int j = removeStart; j <= index; j++) {
                    myMap.remove(s.charAt(j));
                }
                removeStart = index + 1;

                myMap.put(ch, i);
            }
        }

        if(maxLen < myMap.size())
            return myMap.size();
        return maxLen;
    }
}

/**
 * the better answer
 * @author leetcode
 */

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;

        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
// @lc code=end

