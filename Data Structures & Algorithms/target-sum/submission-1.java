class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        Map<String, Integer> dp = new HashMap<>(); 
        //memoisation easy way

        return solve(nums, 0, target, dp);
    }

    private int solve(int[] nums, int i, 
                       int target,  Map<String, Integer> dp){
      
        if(i == nums.length) 
         return target == 0? 1 : 0 ;

        String key = i + "," + target; 

        if(dp.containsKey(key)) return dp.get(key);  
        //already calculated?
  
        // Current number ko + sign diya
        int plus = solve(nums, i+1, target-nums[i], dp);

        // Current number ko - sign diya
        int minus = solve(nums, i+1, target+nums[i], dp);

        dp.put(key, plus + minus); //store into dp, memoise
        
        return plus+minus; 
    }

}