/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start

import java.util.Stack;

/*
 * @date 20240801
 * 类似于使用状态机一样，保存每次压栈之后，此时栈中的最小元素
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

