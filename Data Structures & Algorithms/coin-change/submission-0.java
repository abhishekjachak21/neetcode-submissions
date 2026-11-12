
class Solution {

    static final int INF = 1000000000; //billion 

    public int coinChange(int[] coins, int amount) {

        int ans = fun(coins, 0, amount);

        return ans == INF ? -1 : ans;
    }

    static int fun(int[] coins, int i, int amount) {

        // Success: exact amount formed
        if (amount == 0) {
            return 0;
        }

        // Failure: no coin types left
        if (i == coins.length) {
            return INF;
        }

        int include = INF;

        // Include current coin if it fits
        if (coins[i] <= amount) {
            include = 1 + fun(coins, i, amount - coins[i]);
        }

        // Exclude current coin
        int exclude = fun(coins, i + 1, amount);

        return Math.min(include, exclude);
    }
}
