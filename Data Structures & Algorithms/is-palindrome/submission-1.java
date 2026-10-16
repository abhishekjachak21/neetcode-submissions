class Solution{
    public boolean isPalindrome(String s) {

      int left = 0, right = s.length()-1;

      while(left<right){

        if(!Character.isLetterOrDigit(s.charAt(left))){
            left++;
            continue;
        }

        if(!Character.isLetterOrDigit(s.charAt(right))){
            right--;
            continue;
        }

        char l = Character.toLowerCase(s.charAt(left));
        char r = Character.toLowerCase(s.charAt(right));

       if(l!=r) return false;

       left++;
       right--;

    } 
     
     return true;

    }
} //v1-optimal, space O(1) Tc O(N)... solved on 16-10-2026, chk notes




