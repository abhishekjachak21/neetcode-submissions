class Solution {
    public int characterReplacement(String s, int k) {
        
    int[] freq = new int[26];
    int maxFreq = Integer.MIN_VALUE;    
    int maxLen = 0;
    int left = 0;

    for(int right=0; right<s.length(); right++){
       
       //1. expand
        char ch = s.charAt(right);
        freq[ch-'A']++;
        maxFreq = Math.max(maxFreq, freq[ch-'A']);

       //2. shrink till valid
       while((right-left+1)-maxFreq > k){

        char ij = s.charAt(left);
        freq[ij-'A']--;

        left++;

       } 

       //3. update
       maxLen = Math.max(maxLen, right-left+1);
    }
    return maxLen; 
    }
}

//I became so comfortable with approahch expand-shrink-update...woohoo!
//27 nov 2026, 7.58pm, CG U32F