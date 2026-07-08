class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n= nums.length;

        int left = 0;
        int window=0, minL = Integer.MAX_VALUE;

        for(int right=0; right<n; right++){
 
              window += nums[right];

              while(window >= target){

               minL = Math.min(minL, right-left+1);

               window -= nums[left];
               left++;

              }

        }

        return minL == Integer.MAX_VALUE?0:minL;
        
    }
}

/*
my brute fore 1st attempt(8july2026, 11.49am, fresh morng, dsa, home):
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n= nums.length;
        int minL = Integer.MAX_VALUE;
 
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i+1; j<n; j++){

              sum += (nums[i] + nums[j]);

             if(sum == target && j-i<minL) minL=j-i+1;

            }
        }

        return minL;
        
    }
}
actual ans:

 int n= nums.length;
        int minL = Integer.MAX_VALUE;
 
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){

              sum += nums[j];

             if(sum >= target)
               minL= Math.min(minL, j-i+1);

            }
        }

        return minL==Integer.MAX_VALUE?0:minL;

*/