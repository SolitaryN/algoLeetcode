/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku1(char[][] board) {
        Set<Character> set_line = new HashSet<>();
        Set<Character> set_colomn = new HashSet<>();

        for (int i = 0; i < 9; i++) { 
            set_line.clear();
            set_colomn.clear();

            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(!set_line.contains(board[i][j])){
                        set_line.add(board[i][j]);
                    }else{
                        return false;
                    }
                }

                if(board[j][i] != '.'){
                    if(!set_colomn.contains(board[j][i])){
                        set_colomn.add(board[j][i]);
                    }else{
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if(!validSquare(board, i, j, i + 2, j + 2)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean validSquare(char[][] board, int x1, int y1, int x2, int y2){
        Set<Character> set = new HashSet<>();
        for(int i = x1; i <= x2; ++i){
            for (int j = y1; j <= y2; ++j) {
                if(board[i][j] == '.')
                    continue;

                if(set.contains(board[i][j]))
                    return false;

                set.add(board[i][j]);
            }
        }
        return true;
    }


    /*
     * @date 20240730
     */

    public boolean isValidSudoku(char[][] board) {
        Set<Character> line = new HashSet<>();
        Set<Character> colomn = new HashSet<>();

        for (int i = 0; i < 9; i++) { // colomn
            colomn.clear();
            for (int j = 0; j < 9; j++) { // line
                if (board[j][i] != '.' && colomn.contains(board[j][i])) {
                    return false;
                } 
                if (board[j][i] != '.') {
                    colomn.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i++) { // line
            line.clear();
            for (int j = 0; j < 9; j++) { // colomn
                if (board[i][j] != '.' && line.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    line.add(board[i][j]);
                }
            }
            
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if(!validSquare(board, i, j, i + 2, j + 2)){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

