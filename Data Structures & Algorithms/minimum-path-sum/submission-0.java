class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[]rw : dp) Arrays.fill(rw, -1);

        return solve(grid, m, n, 0, 0, dp);
    }

    private int solve(int[][]grid, int m, int n, int i, int j, int[][] dp){

       // Grid ke bahar // pehle 0 likha tha
        if(i >= m || j >= n) return Integer.MAX_VALUE; 

        // Destination reached
        if(i == m-1 && j == n-1) return grid[i][j];   
 
        if(dp[i][j]!=-1) return dp[i][j];

        int right =  solve(grid, m, n, i, j+1, dp);
        int down = solve(grid, m, n, i+1, j, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}

/* 17-Nov-2026
Math.min(right, down) ka matlab hai:

Mere next step se destination tak ka sabse sasta rasta kaunsa hai?

grid[i][j] + Math.min(right, down) ka matlab hai:

Mere current cell ko bhi include karke destination tak ka sabse sasta rasta kitna hai?
*/