class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) 
           return "";
        
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
       
        for(char c: t.toCharArray())
         target.put(c, target.getOrDefault(c,0)+1);

        int targetSize = target.size();
        int matching = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;

        for(int right=0; right<s.length(); right++){
           
           //1. expand
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch,0)+1);

            if(target.containsKey(ch)){

                if( target.get(ch).equals(window.get(ch)) )
                   matching++;
            } 
            
            //2. shrink while valid
            while(matching == targetSize){

                 //3. update answer
                if(right-left+1 < minLen){
                    start = left;
                    minLen = right-left+1;
                }
                
                //shrink from left, while valid
               char out = s.charAt(left);
               window.put(out, window.get(out)-1);

               if(target.containsKey(out)) {
                 
                if(window.get(out) < target.get(out))
                    matching--;
                
               }

                left++;

            }
        }

        return minLen == Integer.MAX_VALUE ?  
                        "" 
                        : s.substring(start, start + minLen);

    }
}


/* 
took 1.5 hrs. was simple but tough. 
Pattern: Variable Size Sliding Window

Combination of:
- LC 567: Frequency matching
- LC 209: Shortest valid window

Template:
Expand -> While VALID (Update -> Shrink)

Important:
- matching++ when a character's requirement completes.
- matching-- when a character's requirement breaks.
- Use .equals() when comparing two Integer objects. vimp and new thing understood today.
- Store both start and minLen to return substring.

Time: O(n + m) expected
Auxiliary Space: O(1) for fixed English alphabet,
excluding temporary arrays and output.

28 Nov 2026. sat, CG U32F
*/