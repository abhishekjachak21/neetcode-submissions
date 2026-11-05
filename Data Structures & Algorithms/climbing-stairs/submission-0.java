class Solution {

    HashMap<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        return fun(0, n);
    }

    private int fun(int i, int n) {

        // Reached the top
        if (i == n) return 1;

        // Crossed the top
        if (i > n) return 0;

        // Already calculated
        if (dp.containsKey(i)) return dp.get(i);

        // Take 1 step
        int a1 = fun(i + 1, n);

        // Take 2 steps
        int a2 = fun(i + 2, n);

        int ans = a1 + a2;

        // Store result
        dp.put(i, ans);

        return ans;
    }
}