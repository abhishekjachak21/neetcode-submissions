class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = 0;

        // answer ki low and high possibility [BS on Answer pattern]
        for (int pile : piles) {
            high = Math.max(high, pile); // maximum possible eating speed
        }

        int ans = high;

        // Binary Search on Answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {

                ans = mid; // mid speed works, but we need minimum speed
                high = mid - 1;

            } else {

                low = mid + 1; // speed is too slow, increase speed
            }
        }

        return ans;
    }


    private boolean isPossible(int[] piles, int allowedHours, int speed) {

        long eatingHrs = 0;

        for (int pile : piles) {
            
            // hours required to finish this pile
            eatingHrs += pile/speed;

            if(pile%speed!=0) eatingHrs++;

            if (eatingHrs > allowedHours)  return false;
            
        }

        return true;
    }
}