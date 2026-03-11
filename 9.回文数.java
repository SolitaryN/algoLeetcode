/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    /*
     * 使用字符串转换的方法
     */
    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        int length = str.length();

        for (int i = 0; i < length/2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 -i)) {
                return false;
            }
        }
        return true;
    }

    /*
     * 不转换整数到字符串
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }
}
// @lc code=end

