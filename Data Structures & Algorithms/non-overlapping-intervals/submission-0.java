class Solution {
    public int eraseOverlapIntervals(int[][] activities) {

        // Sort by finishing time
        Arrays.sort(activities,
            (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] activity : activities) {

            if (activity[0] >= lastEnd) { //end 2, start 2, are not overlping both

                count++;
                lastEnd = activity[1];
            }
        }

        return activities.length-count;
    }
}

/* i copied code of Activity selection, crazy, easy pizy, hehe

Yahan Greedy kya hai?
Greedy bolta hai:

"Mujhe minimum intervals remove karne hain, isliye main maximum non-overlapping intervals preserve karunga. Har step par sabse jaldi finish hone wala compatible interval select karunga, kyunki usse future intervals ko select karne ki possibilities kam nahi hongi. Isliye mujhe doosri combinations explore karne ki zarurat nahi hai."

*/