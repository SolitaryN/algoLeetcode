import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int num = pairs.length;
        int[] dp = new int[num];    
        Arrays.fill(dp, 1);

        for (int i = 1; i < num; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < num; i++) {
            if(dp[i] > ans)
                ans = dp[i];
        }
        return ans;
    }
}