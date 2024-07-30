import java.util.Arrays;


class Solution {
    /**
     * 滑动窗口类题目，判断s2中是否含有s1的排列，既然是排列就应该想到不同字母出现的次数相等就代表含有。
     * 算法核心：每次往右滑动一次窗口就要把新加入的字母出现次数加1，而滑出窗口的字母出现次数减一
     * @author solitary
     * @param s1
     * @param s2
     * @return 是否s2含有s1的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();
        if(s1Len > s2Len)
            return false;

        int[] count1 = new int[26]; // note the count of s1's chars
        int[] count2 = new int[26]; // note the count of substring of s2's chars

        for (int i = 0; i < s1Len; i++) {
            ++count1[s1.charAt(i) - 'a'];
            ++count2[s2.charAt(i) - 'a'];
        }

        if(Arrays.equals(count1, count2) == true){
            return true;
        }
        
        for (int i = s1Len; i < s2Len; i++) {
            ++count2[s2.charAt(i) - 'a'];  // 核心的两句
            --count2[s2.charAt(i - s1Len) - 'a'];

            if(Arrays.equals(count1, count2)){
                return true;
            }
        }

        return false;
    }
}