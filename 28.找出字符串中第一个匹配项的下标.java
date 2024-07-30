/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {

    // KMP 算法实现匹配
    public int strStr(String haystack, String needle) {
            int[] next = new int[needle.length()];
            buildNext(needle, next);
    
            int i = 0, j = 0; // i 是主串 index， j 是子串
            while (i < haystack.length() && j < needle.length()) {
                if(needle.charAt(j) == haystack.charAt(i)){
                    i += 1;
                    j += 1;
                }else if(j > 0){
                    j = next[j - 1]; // 如果匹配失败，则更新 j，这里是 next[j - 1] 注意
                }else{ // 子串第一个字符就匹配失败，也就是 j == 0
                    i += 1;
                }
    
                if(j == needle.length()){
                    return i - j;
                }
            }
            return -1;
        }
    
        void buildNext(String s, int[] next){
            next[0] = 0;
            int prefixLen = 0;
            int i = 1;
            while(i < s.length()){
                if(s.charAt(prefixLen) == s.charAt(i)){
                    prefixLen += 1;
                    next[i] = prefixLen;
                    i += 1;
                }else{
                    if(prefixLen == 0){
                        next[i] = 0;
                        i += 1;
                    }else{
                        prefixLen = next[prefixLen - 1];
                    }
                }
            }
        }
}
// @lc code=end

