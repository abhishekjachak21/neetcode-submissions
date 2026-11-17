class Solution {
    public int lastStoneWeightII(int[] stones) {
       
        int total = 0;
        for(int num:stones) total += num;

        int capacity = total/2;

        int[][] dp = new int[stones.length][capacity+1];

        for(int[]rw: dp) Arrays.fill(rw, -1);

        //min -> s2 - s1 ...ham highest s1 dundenge, taki diff kam se kam aaye
        int s1 = solve(stones, 0, capacity, dp); 
        int s2 = total - s1 ;  

        return s2-s1;
    }

    private int solve(int[] stones, int i, int capacity, int[][] dp){

        if(i == stones.length || capacity == 0) return 0;

        if(dp[i][capacity]!=-1) return dp[i][capacity];

        int include = 0, exclude = solve(stones, i+1, capacity, dp);

        if(stones[i]<=capacity){
            include = stones[i] + solve(stones, i+1, capacity-stones[i], dp);
        } 
        
        return dp[i][capacity] = Math.max(include, exclude);
    }
}