class Solution {
    public int[] twoSum(int[] nums, int target) {
         
       int n = nums.length;

       Map<Integer, Integer> mp1 = new HashMap<>();

       for(int i=0; i<n; i++){

           int compl = target - nums[i];

           if(mp1.containsKey(compl))
               return new int[]{mp1.get(compl), i};

            mp1.put(nums[i], i);   

       }

       return new int[]{-1, -1};

    }
}
