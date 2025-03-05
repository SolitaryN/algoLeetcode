/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start

import java.util.Stack;

/*
 * @date 20240801 20241005
 * 类似于使用状态机一样，保存每次压栈之后，此时栈中的最小元素
 * 
 * @date 20250305
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack  = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int minVal = Math.min(val, min.isEmpty() ? val : min.peek());
        min.push(minVal);
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
// @lc code=end

