/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /*
     * 20241005
     * 
     * @date 20250305
     * 这里注意压栈和弹栈的时间节点，必须是在处理 [ 符号时，进行压入栈，如果是在处理数字字符的时候，此时如果是多位数字，此时按照下面的方法会造成多次压栈，所以为了确保压栈操作的唯一性，这里必须在 [ 这里进行压栈操作。
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // 存储数字
        Stack<String> stringStack = new Stack<>(); // 存储字符串
        String curString = ""; // 当前解码字符串，可以认为初始化的时候，就是""为初始化
        int curNum = 0; // 当前的倍数

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                curNum = curNum * 10 + (ch - '0'); // 处理多位数
            } else if (ch == '[') {
                // 遇到 '['，将当前的字符串和数字推入各自的栈
                countStack.push(curNum);
                stringStack.push(curString);
                curString = ""; // 重置当前字符串
                curNum = 0; // 重置倍数
            } else if (ch == ']') {
                // 遇到 ']'，解码
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(curString); // 重复当前字符串
                }
                curString = sb.toString(); // 更新当前字符串
            } else if (Character.isLetter(ch)){
                // 如果是字母，直接加到当前字符串
                curString += ch;
            }
        }
        return curString;
    }
}
// @lc code=end

