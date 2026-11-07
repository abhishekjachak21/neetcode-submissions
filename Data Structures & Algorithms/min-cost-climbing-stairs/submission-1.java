class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length ;     //memoization by myself
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fun(cost, dp, n);
        
    }

    private int fun(int[] cost, int[] dp, int n){

        if(n==0 || n==1) return 0; 

        if(dp[n]!=-1) return dp[n];

        int ans = Math.min( 
                fun(cost, dp, n-1)+cost[n-1], 
                fun(cost, dp, n-2)+cost[n-2] 
            );

        dp[n] = ans;

        return ans;

    }
}