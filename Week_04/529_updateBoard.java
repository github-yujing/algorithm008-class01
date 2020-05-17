class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},
                                    {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    private int m;
    private int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M')
            board[row][col] = 'X';
        else {
            m = board.length;
            n = board[0].length;
            dfs(board, row, col);
        }
        return board;
    }


    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'E')
            return;
        
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (0 <= x && x < m && 0 <= y && y < n && board[x][y] == 'M')
                count++;
        }

        if (count != 0) 
            board[i][j] = (char)('0' + count);
        else {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                dfs(board, x, y);
            }
        }
    }
}
