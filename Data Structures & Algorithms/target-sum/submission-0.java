class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int total = 0;
        for(int num:nums) total+=num;

        int offset = total;

        int[][] dp = new int[nums.length][2*offset+1]; 
        //-target to +target

        for(int[] rw: dp) Arrays.fill(rw, -1);

        return solve(nums, 0, target, offset, dp);
    }

    private int solve(int[] nums, int i, int target, int offset, int[][] dp){
      
        if(i == nums.length) 
         return target == 0? 1 : 0 ;

        // Prevent invalid array indexing 
        //this condition is bit different
        if (target < -offset || target > offset) return 0;

        if(dp[i][target+offset]!=-1) return dp[i][target+offset]; 
    
        int plus = solve(nums, i+1, target-nums[i], offset, dp);
        int minus = solve(nums, i+1, target+nums[i], offset, dp); 
        
        return dp[i][target+offset] = plus+minus; 
        //ret total no of diff ways
    }

}