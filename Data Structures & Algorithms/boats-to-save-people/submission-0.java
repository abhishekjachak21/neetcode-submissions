class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

        //if 2 log fit baith rhe hai toh good
            if (people[left] + people[right] <= limit) {
                left++; 
                right--;
                boats++;
            } 
            else{ //nahi toh akele hi jao
                right--;
                boats++;
            } 
            
        }

        return boats;
    }
}

/* 25 nov 2026: Jhakmi parinda hai, fir bhi tu zinda hai...

Greedy ki lalach — Revision
"Main sabse heavy remaining person ko rescue karunga. Agar sabse light person uske saath fit hota hai, toh dono ko bhejunga. Warna heavy ko akela bhejunga."

*/