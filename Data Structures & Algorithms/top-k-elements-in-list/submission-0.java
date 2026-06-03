class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){

          int maxFreq = 0;
          int element = 0;

          for(int num:freq.keySet()){
            
            if(freq.get(num)>maxFreq){
                maxFreq = freq.get(num);
                element = num;
            }

          }


          ans[i] = element;
          freq.remove(element);

        }

      return ans;
        
    }
}