
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int[] merged = new int[3];

        for (int[] t : triplets) {

            if (t[0] > target[0] ||
                t[1] > target[1] ||
                t[2] > target[2]) {
                continue; //entire tripet skip
            } //t[0] t[1] t[2] ye ek hi row h bhai, 1 triplet, isme se ek bhi kuch bada hua toh entire tripet skip

            for (int j = 0; j < 3; j++) {
                merged[j] = Math.max(merged[j], t[j]);
            }

        }

        return Arrays.equals(merged, target);

    }
}

/*

Yahan Greedy kya hai?
Greedy bolta hai:

"Jab merging se values sirf badh sakti hain, toh main target se badi value wale triplets ko discard karunga aur saare valid triplets ko merge kar dunga. Kyunki valid triplets ko merge karne se target overshoot nahi hoga, isliye mujhe alag-alag combinations try karne ki zarurat nahi hai."

*/