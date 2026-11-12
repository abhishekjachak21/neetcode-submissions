class Solution {

    public boolean canPartition(int[] nums) { //memoization

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Odd total cannot be divided equally
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
       
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        
        for(int[] rw:dp)
         Arrays.fill(rw, -1);

        return solve(nums, 0, target, dp);
    }

    static boolean solve(int[] nums, int i, int target, int[][] dp) {

        // Target achieved
        if (target == 0) {
            return true;
        }

        // No numbers left
        if (i == nums.length) {
            return false;
        }

        if(dp[i][target] != -1) return dp[i][target] == 1;

        boolean include = false;

        if (nums[i] <= target) {
            include = solve(nums, i + 1, target - nums[i], dp);
        }

        boolean exclude = solve(nums, i + 1, target, dp);

        boolean ans = include || exclude;

        dp[i][target] = ans? 1: 0;

        return ans;
    }
}