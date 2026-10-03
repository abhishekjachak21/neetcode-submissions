class Solution {
    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target mil gaya
            if (nums[mid] == target)  return true;

            // Duplicates: decide nahi kar paa rahe kaunsi side useful hai
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {

                low++;  //mid!= target, so low,high both cant be target,
                high--;  //so low high ko uda do, and re calculate them
                continue; //aage ka skip krdo, re calculate them
            }

            // LEFT half sorted
            if (nums[low] <= nums[mid]) {

                // Target left sorted range mein hai
                if (nums[low] <= target && target < nums[mid]) { //target <= nums[mid] nhi bcz mid== target wali condition phle hi handle krdi h
                    high = mid - 1;
                } else low = mid + 1;

            }

            // RIGHT half sorted
            else {

                // Target right sorted range mein hai
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else high = mid - 1;
                
            }
        }

        return false;
    }
}