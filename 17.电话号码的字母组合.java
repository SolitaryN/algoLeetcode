/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String> ans = new ArrayList<>();
    Map<Character, String> table = new HashMap<>();

    /*
     * @date 20241009
     * 这里使用循环选择一组 letters 进行
     */
    public List<String> letterCombinations(String digits) {
        table.put('2', "abc");
        table.put('3', "def");
        table.put('4', "ghi");
        table.put('5', "jkl");
        table.put('6', "mno");
        table.put('7', "pqrs");
        table.put('8', "tuv");
        table.put('9', "wxyz");
        
        if (digits.length() == 0) return Collections.emptyList();

        backtrack(0, digits, new StringBuilder());
        return ans;
    }

    void backtrack(int index, String digits, StringBuilder combination) {
        if (index == digits.length()) {
            ans.add(combination.toString());
            return;
        }

        Character digitNow = digits.charAt(index);
        String letters = table.get(digitNow);
        int len = letters.length();
        for (int i = 0; i < len; i++) {
            combination.append(letters.charAt(i));
            backtrack(index + 1, digits, combination);
            // 注意回溯删除的元素是最后一个字符
            combination.deleteCharAt(index);
        }
    }
}
// @lc code=end

