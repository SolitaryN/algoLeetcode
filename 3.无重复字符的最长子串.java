import java.util.HashMap;

class Solution {
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

    public static void main(String[] args) {
        Integer s = new Solution().lengthOfLongestSubstring("aab");
        System.out.println(s);
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