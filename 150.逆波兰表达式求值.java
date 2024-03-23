/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.Stack;

class Solution {
    // ba/
    // 后缀表达式求值是从左往右扫描表达式，是操作数了放入栈在，如果是
    // 操作符 / 要出栈两个数a和b，先出栈若是a，则压栈 b/a

    // /ba
    // 前缀表达式求值是从右往左扫描，核心代码一样，不过先出栈的放前面 
    public int evalRPN(String[] tokens) {
        // 先出栈的放后面，后出栈的放前面
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")
            || tokens[i].equals("-")
            || tokens[i].equals("*")
            || tokens[i].equals("/") ){
                int b = stack.pop();  // 先出栈
                int a = stack.pop();   // 后出栈
                stack.push(helper(a, b, tokens[i]));
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }

    Integer helper(int a, int b, String oper){
        if(oper.equals("+")){
            return a + b;
        }else if(oper.equals("-")){
            return a - b;
        }else if(oper.equals("/")){
            return a / b;
        }else if(oper.equals("*")){
            return a * b;
        }

        assert 1 != 1;
        return -1;
    }
}
// @lc code=end

