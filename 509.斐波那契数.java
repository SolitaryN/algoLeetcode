class Solution {
    public int fib(int n) {
        int f0 = 0, f1 = 1;
        if(n == 0)
            return f0;
        if(n == 1)
            return f1;
        
        int before0 = f0;
        int before1 = f1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = before0 + before1;
            before0 = before1;
            before1 = ans;
        }
        return ans;
    }
}