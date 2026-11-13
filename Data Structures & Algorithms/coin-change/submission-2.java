class Solution {

    static final int INF = 1000000000;

    public int coinChange(int[] coins, int amount) { //tabulation

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // 0 coins reqd for 0 amt
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // no coins present, amt is impossible to build
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= amount; j++) {

                int include = INF;

                if (coins[i - 1] <= j) {
                        include = 1 + dp[i][j - coins[i - 1]];  //i-1 nhi, i hai.
                    }

                int exclude = dp[i - 1][j];

                dp[i][j] = Math.min(include, exclude);
            }
        }

        return dp[n][amount] == INF ? -1 : dp[n][amount];
    }
}
