class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target+1]; //memoization
        Arrays.fill(dp,-1);

        return solve(nums, target, dp);
        
    }

    private int solve(int[] nums, int target, int[] dp){

       if(target==0) return 1;

       int count = 0;
       
       if(dp[target]!=-1) return dp[target];

       for(int i=0; i<nums.length; i++){
       
         if(nums[i]<=target)
           count += solve(nums, target-nums[i], dp);

       }

        return dp[target]=count;
    }
}

/*
Coin Change II: solve(i, target) — 2 changing variables, isliye 2D DP.
Combination Sum IV: solve(target) — sirf 1 changing variable, isliye 1D DP.


Sabse important 3 concepts
1. target == 0 → return 1: Ek valid sequence complete ho gayi.
2. for loop: Har position par saare available numbers try karo, kyunki order matters.
3. count += solve(...): Har choice se milne wali valid sequences ko total mein jodo.
*/