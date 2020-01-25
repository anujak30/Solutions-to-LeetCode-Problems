class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        onClick(click[0], click[1], board);
        return board;
    }
    public void onClick(int x, int y, char[][] board) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        if(board[x][y] == 'M')
            board[x][y] = 'X';
        else if(board[x][y] == 'E') {
            int n = numberOfAdjacentMines(x, y, board);
            if(n == 0) {
                board[x][y] = 'B';
                onClick(x + 1, y, board);
                onClick(x + 1, y + 1, board);
                onClick(x + 1, y - 1, board);
                onClick(x, y, board);
                onClick(x, y + 1, board);
                onClick(x, y - 1, board);
                onClick(x - 1, y, board);
                onClick(x - 1, y - 1, board);
                onClick(x - 1, y + 1, board);
            } 
            else
                board[x][y] = (char) (n + '0');
        }
    }
    public int numberOfAdjacentMines(int x, int y, char[][] board) {
        int mines = 0;
        if(x - 1 >= 0) {
            if(board[x - 1][y] == 'M')  mines++;
            if(y - 1 >= 0 && board[x - 1][y - 1] == 'M')    mines++;
            if(y + 1 < board[0].length && board[x - 1][y + 1] == 'M')   mines++;
        }
        if(y - 1 >= 0 && board[x][y - 1] == 'M')    mines++;
        if(x + 1 < board.length) {
            if(board[x + 1][y] == 'M')  mines++;
            if(y - 1 >= 0 && board[x + 1][y - 1] == 'M')    mines++;
            if(y + 1 < board[0].length && board[x + 1][y + 1] == 'M')   mines++;
        }
        if(y + 1 < board[0].length && board[x][y + 1] == 'M')  mines++;
        return mines;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Minesweeper.
// Memory Usage: 41.9 MB, less than 56.25% of Java online submissions for Minesweeper.