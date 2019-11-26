class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] maxPaths = new int[m][n];
        maxPaths[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)
                    maxPaths[i][j] = 0;
                else{
                    if(i - 1 >=0 && j - 1 >= 0)
                        maxPaths[i][j] = maxPaths[i - 1][j] + maxPaths[i][j - 1];
                    else if(i - 1 < 0 && j - 1 >= 0)
                        maxPaths[i][j] = maxPaths[i][j - 1];
                    else if(i - 1 >= 0 && j - 1 < 0)
                        maxPaths[i][j] = maxPaths[i - 1][j];
                } 
            }
        }
        return maxPaths[m - 1][n - 1];
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
// Memory Usage: 39.1 MB, less than 66.15% of Java online submissions for Unique Paths II.