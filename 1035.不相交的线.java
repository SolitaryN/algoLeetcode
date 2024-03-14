import java.util.Arrays;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len_num1 = nums1.length; // 行
        int len_num2 = nums2.length; // 列

        int[][] dp = new int[len_num1 + 1][len_num2 + 1];

        Arrays.fill(dp[0], 0);
        for (int i = 0; i < len_num1 + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < len_num1 + 1; i++) {
            for (int j = 1; j < len_num2 + 1; j++) {
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len_num1][len_num2];
    }
}