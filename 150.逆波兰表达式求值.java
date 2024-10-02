/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.Stack;

class Solution {
    // 后缀表达式求值是从左往右扫描表达式，是操作数了放入栈在，如果是
    // 操作符 / 要出栈两个数a和b，先出栈若是a，则压栈 b/a

    // 前缀表达式求值是从右往左扫描，核心代码一样，不过先出栈的放前面 
    public int evalRPN1(String[] tokens) {
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

        return -1;
    }

    /*
     * @date 20240802
     * 后缀表达式求值是从左往右扫描表达式，是操作数了放入栈在，如果是
     * 操作符 / 要出栈两个数a和b，先出栈若是a，则压栈 b/a
     * 
     * 前缀表达式求值是从右往左扫描，核心代码一样，不过先出栈的放前面 
     * 
     * 在switch语句中,case标签的值必须是编译时常量，以便编译器在编译时就能确定跳转表
     * 常见的就是：字符串(jdk7开始支持)、基本数据类型
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            Integer i = s2i(str);
            if (i != null) {
                stack.push(i);
            } else if (i == null) {
                Integer s = eval(str, stack.pop(), stack.pop());
                stack.push(s);
            }
        }

        return stack.pop();
    }

    Integer s2i(String str) {
        Integer ans;
        try {
            ans = Integer.valueOf(str);
        } catch (Exception e) {
            return null;
        }
        return ans;
    }

    Integer eval(String evalCh, Integer second, Integer first) {
        switch (evalCh) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;
        }
        return 0;
    }
}
// @lc code=end

