/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    boolean ans = false;
    boolean[][] visited;


    /*
     * @date 20241009
     * 使用回溯，这里记录元素是否重合到之前走的路径，如果是则返回，不能走旧路径上的元素
     * 这里使用 visited 用来表示是否之前的路径访问过
     */
    public boolean exist(char[][] board, String word) {
        int nr = board.length, nc = board[0].length;
        Character head = word.charAt(0);
        visited = new boolean[nr][nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (head.equals(board[i][j])) {
                    backtrack(i, j, board, 0, word);
                }
            }
        }
        return ans;
    }

    void backtrack(int line, int colomn, char[][] board, int index, String word) {
        int len = word.length();
        int nr = board.length, nc = board[0].length;

        if (len == index) {
            ans = true;
            return;
        }

        if (line >= nr || line < 0 || colomn >= nc || colomn < 0)  return;
        if (visited[line][colomn] == true || 
            word.charAt(index) != board[line][colomn]) return;

        visited[line][colomn] = true;
        backtrack(line + 1, colomn, board, index + 1, word);
        backtrack(line - 1, colomn, board, index + 1, word);
        backtrack(line, colomn + 1, board, index + 1, word);
        backtrack(line, colomn - 1, board, index + 1, word);
        visited[line][colomn] = false;
    }
}
// @lc code=end

