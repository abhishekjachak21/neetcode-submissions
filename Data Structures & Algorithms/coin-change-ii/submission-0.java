class Solution {
    
    public int change(int amount, int[] coins) { //memoization approach(13-nov-26)

        int[][] dp = new int[coins.length][amount+1];

        for(int[] rw:dp) Arrays.fill(rw, -1);

        return solve(coins, 0, amount, dp);
        
    }

    private int solve(int[] coins, int i, int amount, int[][] dp){

        // Success first
        if (amount == 0) return 1;

        // Failure second
        if (i == coins.length) return 0; //base cases ka sequence bhi imp h

       if(dp[i][amount]!=-1) return dp[i][amount];

       int include = 0, exclude = solve(coins, i+1, amount, dp);

       if(coins[i]<=amount)
        include = solve(coins, i, amount-coins[i], dp);

       int ans = include + exclude;

        return dp[i][amount] = ans; 
    }

}