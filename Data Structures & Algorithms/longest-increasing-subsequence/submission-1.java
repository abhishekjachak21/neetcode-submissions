class Solution {
    public int lengthOfLIS(int[] nums) {
       
       int n = nums.length;
        int[][] dp = new int[n][n+1];  //memoization
        
        for(int[]rw : dp) Arrays.fill(rw, -1);

        return solve(nums, 0, -1, dp);
    }

    private int solve(int[] nums, int i, int prev, int[][] dp) {

        // Base case: Array khatam
        if (i == nums.length) return 0;

        //Already calcluated???
        if(dp[i][prev+1]!=-1) return dp[i][prev+1]; //bcz dp[i][-1] is invalid
        //Agar isi current index aur isi previously selected index wali problem pehle solve ho chuki hai, toh dobara calculate mat karo.


        // Exclude: Current element skip karo
        int exclude = solve(nums, i + 1, prev, dp);

        // Include: Current element choose karo
        int include = 0;

        if (prev == -1 || nums[i] > nums[prev]) {
            include = 1 + solve(nums, i + 1, i, dp); 
            //ab curr i, agle ka prev banega
        }

        return dp[i][prev+1] = Math.max(include, exclude);
    }
}