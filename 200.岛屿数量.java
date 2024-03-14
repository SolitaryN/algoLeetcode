
class Solution {

    public int numIslands(char[][] grid) { 

        char[][] status = new char[grid.length][grid[0].length];
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[0].length; j++) {
                status[i][j] = '0';
            }
        }

        int sum = 0;

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && status[i][j] == '0'){ // 如果是路地块，且没被检查过
                // if(grid[i][j] == '1'){ // 如果是路地块，且没被检查过
                    checkLand(i, j, status, grid);
                    // checkLand2(i, j, grid);
                    sum++;
                }
            }
        }

        return sum;
    }

    public void checkLand(int line, int colomn, char[][] status, char[][] grid){
        if(line < 0 || colomn < 0 || line >= grid.length || colomn >= grid[0].length || status[line][colomn] == '1' || grid[line][colomn] == '0'){
            // 参数违规或者不是陆地，或者已经被访问过了就不要继续往下递归访问了
            // 这里要注意，如果你要使用 status 进行访问状态的管理的时候，不要忘记已经被访问过的就不用访问了，否则会导致无限递归，产生栈溢出
            return;
        }

        status[line][colomn] = '1';
        checkLand(line - 1, colomn, status, grid);
        checkLand(line + 1, colomn, status, grid);
        checkLand(line , colomn + 1, status, grid);
        checkLand(line, colomn - 1, status, grid);
    }


    public void checkLand2(int line, int colomn, char[][] grid){
        // 只往下左右去遍历
        if(line < 0 || colomn < 0 || line >= grid.length || colomn >= grid[0].length || grid[line][colomn] == '0')
            return;

        grid[line][colomn] = '0';
        checkLand2(line - 1, colomn, grid);
        checkLand2(line + 1, colomn, grid);
        checkLand2(line , colomn + 1, grid);
        checkLand2(line, colomn - 1, grid);
    }
}