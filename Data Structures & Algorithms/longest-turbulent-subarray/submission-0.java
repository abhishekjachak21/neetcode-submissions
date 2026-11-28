class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int left = 0;
        int maxLen = 1;
        int prev = 0;

        for (int right = 1; right < arr.length; right++) {

            // 1. Expand and find current comparison
            int curr = Integer.compare(
                arr[right], arr[right - 1]
            );

            // 2. Repair invalid window
            if (curr == 0) {

                left = right;

            } else if (curr == prev) { //window piche se hi start hongi we already know

                left = right - 1;
            }

            // 3. Update answer
            maxLen = Math.max(maxLen, right - left + 1);

            // Save comparison for next iteration
            prev = curr;
        }

        return maxLen;
    }
}



/*

Template:
Expand -> Repair invalid window -> Update

Important:
- Integer.compare() returns -1, 0 or 1.
- Equal elements: left = right.
- Same nonzero comparison: left = right - 1.
- Alternating comparison: continue expanding. do nothing.
- No while loop needed because we know
  the exact valid starting boundary.
- prev = curr for the next iteration.

Time Complexity: O(n)
Auxiliary Space Complexity: O(1)

Situation	Repair	Retain
Equal elements	left = right	1 element
Same comparison repeated	left = right - 1	2 elements
Alternating comparison	Do nothing	Entire window
*/