class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            // 1. Expand
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);

            // 2. Shrink while INVALID
            while(map.size()>2){
                
                map.put(fruits[left], map.get(fruits[left])-1);

                if(map.get(fruits[left])==0)
                   map.remove(fruits[left]);

                left++;   
            }

            // 3. Update answer
            maxLen = Math.max(maxLen, right-left+1);

        }

        return maxLen;
    }
}

/*

Garden, trees, fruits aur baskets sirf story hai.
Actual question hai:
Find the longest contiguous subarray containing at most 2 distinct elements.

dhyaan rahe 
- map.put(fruits[left], map.get(fruits[left])-1);, yaha ordefault ki jarurat ni thi
- length = right-left+1
- if values = 0, remove that fruit

*/