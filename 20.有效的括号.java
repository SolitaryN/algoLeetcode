/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || map.get(c) != stack.peek())
                    return false;
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    /*
     * @date 20241005
     * 注意判断是否成对的时候，传入的左右括号值
     */
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                char p = stack.pop();
                if (!isPair(p, c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    Boolean isPair(char left, char right) {
        if (left == '[' && right == ']')
            return true;
        if (left == '(' && right == ')')
            return true;
        if (left == '{' && right == '}')
            return true;
        return false;
    }
}
// @lc code=end