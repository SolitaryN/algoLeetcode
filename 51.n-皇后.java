/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    /**
     *  @date 20250328
     * '.' 表示空，'Q' 表示皇后，初始化空棋盘。
     * https://labuladong.online/algo/practice-in-action/sudoku-nqueue/
     * 
     * @param n 输入棋盘边长 n，返回所有合法的放置
     * @return 所有合法的放置
     */

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        List<String> board = new ArrayList<>();
        IntStream.range(0, n).forEach(_i -> {
            board.add(".".repeat(n)); // java11 后才有 repeat 函数
        });

        backtrack(board, 0);

        return res;
    }

    /**
     * 回溯算法的核心
     * @param board 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * @param row 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     */
    private void backtrack(List<String> board, int row) {
        // 收割结果，触发结束
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 进行剪枝操作，排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }

            char[] newRow = board.get(row).toCharArray();
            newRow[col] = 'Q';
            board.set(row, new String(newRow));

            backtrack(board, row + 1); // 进入下一行决策

            newRow[col] = '.'; // 撤销选择
            board.set(row, new String(newRow));
        }
    }

    /*
     * 判断是否可以在 board[row][col] 放置皇后
     */
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查 列 是否有皇后互相冲突，只用判断当前行上方
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }

        // 检查 右上方 是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        // 检查 左上方 是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        return true;
    }
}

// @lc code=end

