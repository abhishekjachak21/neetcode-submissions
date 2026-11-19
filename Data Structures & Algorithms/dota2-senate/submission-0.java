class Solution {
    public String predictPartyVictory(String senate) {

        int n = senate.length();

        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new LinkedList<>();

        // Store positions
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                r.add(i);
            else
                d.offer(i);
        }

        // Continue until one party is eliminated
        while (!r.isEmpty() && !d.isEmpty()) {

            int ri = r.poll();
            int di = d.poll();

            if (ri < di) {
                // R acts first and survives
                r.offer(ri + n);    
                //ye +n itna abi clear ni h, dekhte h aage.
            } else {
                // D acts first and survives
                d.offer(di + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}