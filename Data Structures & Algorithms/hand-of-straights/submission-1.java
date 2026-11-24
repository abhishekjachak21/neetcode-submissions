class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;

        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {

            if (map.get(num) == 0) continue; //frq 0, next element

            for (int j = 0; j < groupSize; j++) {

                int card = num + j;  

                if (map.getOrDefault(card, 0) == 0)
                    return false;

                map.put(card, map.get(card) - 1);
            }
        }

        return true;
    }
}

/*
Bhai, is problem mein Greedy thoda hidden hai, kyunki yahan hum kuch maximize ya minimize nahi kar rahe hain. Hum sirf check kar rahe hain ki valid grouping possible hai ya nahi.

Yahan Greedy ka actual decision hai — sabse chhote unused card ko group ka starting point banana aur bina doosri combinations try kiye uska group complete kar dena.




Greedy bolta hai:

"Jab mujhe pata chal gaya ki sabse chhote unused card se hi uska group start hona compulsory hai, toh main doosri combinations explore nahi karunga. Seedha usse consecutive group banaunga. Agar woh group nahi ban paya, toh valid solution possible hi nahi hai."

Bas teen cheezein dimaag mein rakho: Outer loop group start karta hai, inner loop group complete karta hai, aur HashMap cards ki availability manage karta hai.



Haan bhai, bilkul! Humne physically koi group banaya hi nahi. Humne sirf HashMap mein frequencies decrease karke group formation ko simulate kiya hai.
*/