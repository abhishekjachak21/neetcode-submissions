
class Solution {  //memoization
  
    static final int INF = 1000000000; //billion 

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];
         
        for(int[] rw: dp) 
           Arrays.fill(rw, -1);

        int ans = fun(coins, 0, amount, dp);

        return ans == INF ? -1 : ans;
    }

    static int fun(int[] coins, int i, int amount, int[][] dp) {

        // Success: exact amount formed
        if (amount == 0) {
            return 0;
        }

        // Failure: no coin types left
        if (i == coins.length) {
            return INF;
        }

        if(dp[i][amount]!=-1) return dp[i][amount];  //heart of memoization

        int include = INF;

        // Include current coin if it fits
        if (coins[i] <= amount) {
            include = 1 + fun(coins, i, amount - coins[i], dp);
        }

        // Exclude current coin
        int exclude = fun(coins, i + 1, amount, dp);

        return dp[i][amount] = Math.min(include, exclude);
    }
}