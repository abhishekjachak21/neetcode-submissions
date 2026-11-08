class Solution {
    public int rob(int[] nums) {    //memoization way (8-nov-2026)

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return fun(nums, dp, 0);   
    }

    private int fun(int[] nums, int[] dp, int i) {

        // No houses remaining
        if (i >= nums.length) return 0;

        //heart of memoization
        if(dp[i]!=-1) return dp[i];

        // Choice 1: Rob current house
        int take = nums[i] + fun(nums, dp, i + 2);

        // Choice 2: Skip current house
        int skip = fun(nums, dp, i + 1);

        // Choose maximum money
        int ans = Math.max(take, skip);

        dp[i] = ans;

        return ans;
    }
}