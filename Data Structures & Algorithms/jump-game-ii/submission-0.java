class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Ek aur jump se maximum reach
            farthest = Math.max(farthest, i + nums[i]);

            // Current jump ki range finish
            if (i == currentEnd) {

                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
