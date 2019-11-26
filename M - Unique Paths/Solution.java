class Solution {
    public int uniquePaths(int m, int n) {
        int[][] maxPaths = new int[m][n];
        maxPaths[0][0] = 1;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row - 1 >= 0 && col - 1 >= 0)
                    maxPaths[row][col] = maxPaths[row][col - 1] + maxPaths[row - 1][col];
                else if(col - 1 < 0 && row - 1 >= 0)
                    maxPaths[row][col] = maxPaths[row - 1][col];
                else if(row - 1 < 0 && col - 1 >= 0)
                    maxPaths[row][col] = maxPaths[row][col - 1];
            }
        }
        return maxPaths[m - 1][n - 1];
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
// Memory Usage: 33.1 MB, less than 5.10% of Java online submissions for Unique Paths.
// Can also replace in grid[][] itself instead on minDist