
class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index tak pahunch hi nahi sakte
            if (i > maxReach) {
                return false;
            }

            // Maximum possible reach update karo
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index reachable hai
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}


/*
Bhai, Greedy ka ek golden principle yahan se seekh:
Jab multiple paths ka future sirf ek best boundary (maxReach) se represent ho sakta hai, toh humein har path separately explore karne ki zarurat nahi.

Yahi Jump Game ki actual Greedy intuition hai.
*/