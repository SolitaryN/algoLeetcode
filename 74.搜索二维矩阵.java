/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;

        int l = matrix.length, c = matrix[0].length;
        int i = 0, j = 0;
        while (i < l && j < c) {
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                return false; // 出现这种情况，说明没有这个元素
            }

            if(i + 1 < l && matrix[i + 1][j] <= target){
                i++;  // 先往下查
            }else{
                j++;  // 再往右查
            }
        }

        return false;
    }
}
// @lc code=end

