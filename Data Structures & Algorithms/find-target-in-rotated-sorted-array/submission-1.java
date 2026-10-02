class Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // 1. Sabse pehle check: mid hi target hai?
            if (nums[mid] == target) {
                return mid;
            }

            // 2. LEFT half sorted hai
            if (nums[low] <= nums[mid]) {

                // Target LEFT sorted range ke andar hai?
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;   // left jao
                } else {
                    low = mid + 1;    // right jao
                }
            }

            // 3. Otherwise RIGHT half sorted hai
            else {

                // Target RIGHT sorted range ke andar hai?
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;    // right jao
                } else {
                    high = mid - 1;   // left jao
                }
            }
        }

        return -1;
    }
}