class Solution {
    public int findMin(int[] nums) {
        
     int low=0, high=nums.length-1, ans=-1;

     while(low<high){
        int mid = low+(high-low)/2;

        if(nums[mid]>nums[high]) low=mid+1;  //part1 mei dekho,part2 mei sab max h, right mei jao, left ki possibilities 0 hogyi ab
        
        else {
            high=mid;    //store krlo, right ki possibilities 0 hogyi ab, left mei hi hai answer...lekin high bhi mid ho sakta h.
            // high=mid made this tough for me, revision needed
        }

     }
return nums[low];
    }
}