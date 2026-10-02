class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        // answer ki low and high possibility [VIMP, BS on Answer pattern]
        for (int weight : weights) {
            low = Math.max(low, weight); // minimum possible capacity
            high += weight;              // maximum possible capacity
        }

        int ans = high;

        // Binary Search on Answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(weights, days, mid)) {
                // mid capacity works, but we need minimum capacity
                ans = mid;
                high = mid - 1;
            } else {
                
                low = mid + 1; // capacity is too small, move ahead
            }
        }

        return ans;
    }


    private boolean isPossible(int[] weights, int allowedDays, int capacity) {

        int daysUsed = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight <= capacity) {
 
                currentLoad += weight; // Put package on current day

            } else {

                daysUsed++; // Start a new day
                if (daysUsed > allowedDays)  return false;

                currentLoad = 0;  //new day, new load
                currentLoad += weight;                
            }


        }

        return true;
    }
}