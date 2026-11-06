class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(nums, n, 0, 1, dp);
    }

    private int fun(int[] nums, int n, int i, int free, int[][] dp) {

        // Base case
        if (i == n) return 0;

        // Already calculated
        if (dp[i][free] != -1) return dp[i][free];

        // Cannot rob current house
        if (free == 0) {
            return dp[i][free] = fun(nums, n, i + 1, 1, dp);
        }

        // Choice 1: Rob current house
        int c1 = nums[i] + fun(nums, n, i + 1, 0, dp);

        // Choice 2: Skip current house
        int c2 = fun(nums, n, i + 1, 1, dp);

        // Store maximum
        return dp[i][free] = Math.max(c1, c2);
    }
}