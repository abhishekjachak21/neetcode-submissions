class Solution {
    public int majorityElement(int[] nums) {
        
       int n = nums.length;
       Map<Integer, Integer> freq = new HashMap<>();


      for (int num: nums){

        int count = freq.getOrDefault(num,0)+1;
         freq.put(num, count ); 

        if(count>n/2)  return num;

      }

      return -1;
    }
}