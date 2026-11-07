class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length ;     //tabulation by myself
        int[] dp = new int[n+1];
        return fun(cost, dp, n);
        
    }

    private int fun(int[] cost, int[] dp, int n){

        if(n==0 || n==1) return 0; 

        dp[0] = 0;
        dp[1] = 0;

      for(int i=2; i<=n; i++){
        
        dp[i] = Math.min(
            cost[i-1]+dp[i-1], 
            cost[i-2]+dp[i-2]
        );

      }

      return dp[n];

    }
}