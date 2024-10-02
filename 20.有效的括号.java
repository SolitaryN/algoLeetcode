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
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        char[] cs = s.toCharArray();

        for(char c : cs){
            if(c == '{' || c == '[' || c == '('){
                stack.add(c);
            }else{
                Character temp = ' ';
                if(c == '}'){
                    temp = '{';
                }else if(c == ']'){
                    temp = '[';
                }else if(c == ')'){
                    temp = '(';
                }

                if(stack.isEmpty() || !(stack.peek() == temp)){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.empty()?true:false;
    }

    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        if(s.length() % 2 == 1)
            return false;
        
        Stack<Character> stack = new Stack<>();
        char[] ca = s.toCharArray();
        for(char c : ca){
            if(map.containsKey(c)){
                if(stack.isEmpty() || map.get(c) != stack.peek()){
                    return false;
                }
                stack.pop();
            }else{
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }

    /*
     * @date 20240801
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();

        for (char c : str) {
            if (isLeft(c)) {
                stack.push(c);
            }

            if (isRight(c)) {
                if (stack.size() > 0) {
                    char left = stack.pop();
                    if (!isPair(left, c)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    Boolean isLeft(char c) {
        if (c == '[' || c == '(' || c == '{') {
            return true;
        }
        return false;
    }

    Boolean isRight(char c) {
        if (c == ')' || c == ']' || c =='}') {
            return true;
        } 
        return false;
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

