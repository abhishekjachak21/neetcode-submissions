class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int k = low + (high - low) / 2;

            long hours = 0;
            
            // Calculate required hours for speed k
            for (int pile : piles) {
                hours += pile / k ;
                if(pile%k!=0) hours++;
            }

            if (hours <= h) {
                // 32 rs ki shirt mil gayi, but kya pata 30 ki mil jaye
                ans = k;
                high = k - 1;
            } else {
                // 19rs ki shirt ni chhaiye, minimum 30 se aage ki chhaiye
                low = k + 1;
            }
        }

        return ans;
    }
}