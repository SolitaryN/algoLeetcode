import java.util.LinkedList;
import java.util.Queue;

class Solution {

static class NextCell{
    int x;
    int y;

    NextCell(int x, int y){
        this.x = x;
        this.y = y;
    }
}

static NextCell[] next = new NextCell[]{
    new NextCell(0, -1),
    new NextCell(0, 1),
    new NextCell(1, 0),
    new NextCell(-1, 0)
};

    public void solve(char[][] board) {
        int line = board.length;
        int colomn = board[0].length;
        Queue<int []> queue = new LinkedList<>();

        for (int i = 0; i < line; i++) {
            if(board[i][0] == 'O'){
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }

            if(board[i][colomn - 1] == 'O'){
                queue.offer(new int[]{i, colomn - 1});
                board[i][colomn-1] = 'A';
            }
        }

        for (int i = 1; i < colomn - 1; i++) {
            if(board[0][i] == 'O'){
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }

            if(board[line - 1][i] == 'O'){
                queue.offer(new int[]{line - 1, i});
                board[line - 1][i] = 'A';
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                // 四种情况，bfs 遍历的
                int next_x = x + next[i].x;
                int next_y = y + next[i].y;

                if(next_x < 0 || next_x >= line || next_y < 0|| next_y >= colomn || board[next_x][next_y] != 'O'){
                    continue;
                }

                board[next_x][next_y] = 'A';
                queue.offer(new int[]{next_x, next_y});
            }
        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < colomn; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'A')
                    board[i][j] = 'O';
            }
        }
    }

}