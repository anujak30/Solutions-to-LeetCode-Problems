class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return answer;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++)
                answer.add(matrix[top][i]);
            for(int j = ++top; j <= bottom; j++)
                answer.add(matrix[j][right]);
            if(top > bottom)
                break;
            for(int i = --right; i >= left; i--)
                answer.add(matrix[bottom][i]);
            if(left > right)
                break;
            for(int j = --bottom; j >= top; j--)
                answer.add(matrix[j][left]);
            left++;
        }
        return answer;
    }
}
    
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
// Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Spiral Matrix.
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 // This is not the correct method, I'm just trying a recursive approach for this too. Please ignore this.   
    // public List<Integer> helper(int x, int y, int rows, int columns, List<Integer> answer, int[][] matrix) {
    //     List<Integer> newAnswer = new ArrayList<Integer>(answer);
    //     if(x <= rows && y <= columns) {
    //         newAnswer.addAll(traverseRow(x, y, columns, matrix)); // x constant, go from y to columns            
    //         newAnswer.addAll(traverseColumn(x + 1, columns, rows, matrix)); // go from x to rows, columns constant
    //         if(x != rows || y != (columns - 1))
    //             newAnswer.addAll(reverseRow(rows, columns - 1, y, matrix)); // row constant, go from columns to y
    //         if((x + 1) != (rows - 1) || columns != y)
    //             newAnswer.addAll(reverseColumn(rows - 1, y, x + 1, matrix)); // rows to x-1, y constant
    //         newAnswer = helper(x + 1, y + 1, rows - 1, columns - 1, newAnswer, matrix);
    //     } 
    //     return newAnswer;
    // }
    // public List<Integer> traverseRow(int x, int y, int columns, int[][] matrix) {
    //     List<Integer> subAnswer = new ArrayList<Integer>();
    //     for(int j = y; j <= columns; j++)
    //         subAnswer.add(matrix[x][j]);
    //     return subAnswer;
    // }
    // public List<Integer> traverseColumn(int x, int columns, int rows, int[][] matrix) {
    //     List<Integer> subAnswer = new ArrayList<Integer>();
    //     for(int i = x; i <= rows; i++)
    //         subAnswer.add(matrix[i][columns]);
    //     return subAnswer;
    // }
    // public List<Integer> reverseRow(int rows, int columns, int y, int[][] matrix) {
    //     List<Integer> subAnswer = new ArrayList<Integer>();
    //     for(int j = columns; j >= y; j--)
    //         subAnswer.add(matrix[rows][j]);
    //     return subAnswer;
    // }
    // public List<Integer> reverseColumn(int rows, int y, int x, int[][] matrix) {
    //     List<Integer> subAnswer = new ArrayList<Integer>();
    //     for(int i = rows; i >= x; i--)
    //         subAnswer.add(matrix[i][y]);
    //     return subAnswer;
    // }
}