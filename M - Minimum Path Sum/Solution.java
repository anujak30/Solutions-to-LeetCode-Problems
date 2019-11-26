class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minDist = new int[m][n]; 
        minDist[0][0] = grid[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i - 1 >= 0 && j - 1 >= 0)
                    minDist[i][j] = Math.min(minDist[i - 1][j], minDist[i][j - 1]) + grid[i][j];
                else if(i - 1 >= 0 && j - 1 < 0)
                    minDist[i][j] = minDist[i - 1][j] + grid[i][j];
                else if(j - 1 >= 0 && i - 1 < 0)
                    minDist[i][j] = minDist[i][j - 1] + grid[i][j];
            }
        }
        return minDist[m - 1][n - 1];
    }
}
// Runtime: 2 ms, faster than 90.24% of Java online submissions for Minimum Path Sum.
// Memory Usage: 42.7 MB, less than 68.92% of Java online submissions for Minimum Path Sum.