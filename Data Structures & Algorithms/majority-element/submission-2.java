class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i : nums){
          mp.put(i, mp.getOrDefault(i,0)+1);
        }

        // for(int num: nums)
        //   if(mp.get(num)> n/2) return num;

        for(Map.Entry<Integer, Integer> ans: mp.entrySet()){
            if(ans.getValue()>n/2) return ans.getKey();
        }
        
        return -1;
    }
}