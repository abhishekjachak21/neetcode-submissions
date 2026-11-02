class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int idx = 0;

        for (int right = 0; right < n; right++) {

            // 1. Remove expired indices
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(right);

            // 4. Process complete window
            if (right - left + 1 == k) {

                ans[idx++] = nums[deque.peekFirst()];

                left++;
            }
        }

        return ans;
    }
}