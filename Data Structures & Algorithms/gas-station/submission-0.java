
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas=0, totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
         totalGas += gas[i];
         totalCost += cost[i];
        }

        if(totalCost>totalGas) return -1;

        for (int i = 0; i < gas.length; i++) {

            int net = gas[i] - cost[i];
            tank = tank + net;  //pehle ka bacha hua add kro

            if (tank < 0) {
                start = i + 1; //jaha fail, uske aage se start
                tank = 0; //tank empty kro
            }
        }

        return start;
    }
}

/* 24-Nov-2026
Yahan Greedy kya hai?
Greedy bolta hai:

"Jab mujhe pata chal gaya ki current starting point se lekar failure point tak ke saare starts fail honge, toh main unhe ek-ek karke dobara test nahi karunga. Seedha failure point ke agle pump se try karunga."


//really easy but harder to understand in first see
// Greedy really forces me to procrastinate last 3 days. but now, 
i decided to fight against it for nxt 2-3 days. 
then i will start DP again.

*/
