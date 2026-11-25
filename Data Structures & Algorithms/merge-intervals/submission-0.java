class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];

        for (int[] interval : intervals) {

            if (interval[0] <= lastEnd) {

                lastEnd = Math.max(lastEnd, interval[1]);

            } else {

                result.add(new int[]{lastStart, lastEnd});

                lastStart = interval[0];
                lastEnd = interval[1];
            }
        }

        result.add(new int[]{lastStart, lastEnd});

        return result.toArray(new int[result.size()][]);
    }
}


/*

Yahan Greedy kya hai?
Greedy bolta hai:

"Jab intervals starting time ke according sorted hain, toh main har overlapping interval ko immediately current interval mein merge kar dunga. Aur jaise hi non-overlapping interval milega, main purane merged interval ko permanently finalize kar dunga. Kyunki aage aane wale intervals ke starting points aur bhi bade honge, isliye woh purane interval se overlap nahi kar sakte."
*/