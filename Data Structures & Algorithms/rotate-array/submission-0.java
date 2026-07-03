class Solution {

    public void rotate(int[] nums, int k) {

      int n = nums.length;
      k = k%n;

      rotate(0, n-1, nums);

      rotate(0, k-1, nums);

      rotate(k, n-1, nums);

    }

    public static void rotate(int s, int e, int[] arr){
 
       while(s<e){

        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        s++;
        e--;

       }
    }
}






/* brute force (1-july-2026): i submit this solutions 1/day, even if i solve 2/day

class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n ; //k %= n;

        while (k > 0) {

            int last = nums[n - 1];

            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }

            nums[0] = last;

            k--;
        }
    }
}

*/