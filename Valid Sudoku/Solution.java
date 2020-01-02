class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new HashSet[9];
        Set[] columns = new HashSet[9];
        Set[] blocks = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            blocks[i] = new HashSet<Character>();
        }
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                char currentChar = board[row][col];
                if(currentChar != '.') {
                    int mapping = ((row / 3) * 3) + (col / 3);
                    if(rows[row].contains(currentChar) || columns[col].contains(currentChar) || blocks[mapping].contains(currentChar))
                        return false;
                    else {
                        rows[row].add(currentChar);
                        columns[col].add(currentChar);
                        blocks[mapping].add(currentChar);
                        
                    }
                }
            }
        }
        return true;
    }
}

// Runtime: 3 ms, faster than 71.77% of Java online submissions for Valid Sudoku.
// Memory Usage: 44 MB, less than 81.16% of Java online submissions for Valid Sudoku.