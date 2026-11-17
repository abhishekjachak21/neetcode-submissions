class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int m = grid.length; //rows
        int n = grid[0].length; //no of columns derived from row 0 length

        int[][] dp = new int[m][n];

        for (int[] rw : dp) 
            Arrays.fill(rw, -1);

        return solve(grid, m, n, 0, 0, dp); //i & j used for traversing arr
    }
    
    private int solve(int[][] grid, int m, int n, int i, int j, int[][] dp){

       if(i >= m || j >= n) return 0;
       if(grid[i][j] == 1) return 0; //obstacle h yaha, yaha se rasta ni milega.
       if(i == m-1 && j == n-1) return 1;

       if(dp[i][j]!=-1) return dp[i][j];

       int right = solve(grid, m, n, i, j+1, dp);
       int down = solve(grid, m, n, i+1, j, dp);

       return dp[i][j] = right+down;

    }
}