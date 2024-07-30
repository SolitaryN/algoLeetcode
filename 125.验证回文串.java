/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome1(String s) {
        char[] sChar = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : sChar){
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
                sb.append(c);
            }
        }

        String sAfter = sb.toString();
        int ptr1 = 0;
        int ptr2 = sAfter.length() - 1;
        while(ptr2 >= ptr1){
            char c1, c2;
            c1 = sAfter.charAt(ptr1);
            c2 = sAfter.charAt(ptr2);

            if(c1 != c2){
                return false;
            }
            ptr1++; ptr2--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i)) ){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String a = sb.toString();
        sb.reverse();
        String b = sb.toString();

        return a.equals(b);
    }
}
// @lc code=end

