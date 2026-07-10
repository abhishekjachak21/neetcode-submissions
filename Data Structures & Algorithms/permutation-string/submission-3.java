
class Solution {
    public boolean checkInclusion(String s1, String s2) {

       int m = s1.length(), n=s2.length();

        if (m > n) return false;

       int[] freq = new int[26];
       int[] window = new int[26];

       for(int i=0; i<m; i++){
           freq[s1.charAt(i)-'a']++;
           window[s2.charAt(i)-'a']++;
       }

       if(Arrays.equals(freq, window)) return true;

       for(int i=m; i<n; i++){

         window[s2.charAt(i)-'a']++;

        window[s2.charAt(i-m)-'a']--;
       
        if(Arrays.equals(freq, window)) return true;

       }

       return false;

    }
}