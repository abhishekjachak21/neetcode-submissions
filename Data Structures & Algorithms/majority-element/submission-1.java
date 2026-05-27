class Solution {
    public int majorityElement(int[] nums) {
        
     int candidate=0, count = 0;

     for(int num:nums){

       if(count == 0) candidate = num;

       if(candidate == num)
           count++;
       else count--;
     
     }

     return candidate;

    }
}
//above is boyer-moore algo, for Sc 0(1)



// class Solution {
//     public int majorityElement(int[] nums) {
        
//        int n = nums.length;
//        Map<Integer, Integer> freq = new HashMap<>();


//       for (int num: nums){

//         int count = freq.getOrDefault(num,0)+1;
//          freq.put(num, count ); 

//         if(count>n/2)  return num;

//       }

//       return -1;
//     }
// }