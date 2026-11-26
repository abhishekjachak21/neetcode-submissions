class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        int[] last = new int[26];

        for(int i=0; i<s.length(); i++ ) //sabki last occurance wali index store kro
            last[s.charAt(i)-'a'] = i;

        int start = 0, end = 0 ;

        for(int i=0; i<s.length(); i++){
            
            //jo ele added h unka last occurance tk jana padega
            end = Math.max(end, last[s.charAt(i)-'a']);  

            if(i == end){  //temp end tk pohch gaye
                int partitionSize = end-start+1;
                result.add(partitionSize);
                start = i+1;  //naya partition start
            }

        }  

        return result;
    }
}

/* 26 Nov 2026

Actual Greedy kahan hai? 🔥
Greedy ki lalach: Jitni jaldi valid partition bana sakta hoon, utni jaldi bana dunga, taaki maximum number of partitions mil sakein.

Math.max() ensure karta hai ki partition valid rahe, aur i == end ensure karta hai ki hum earliest possible point par partition close karein.

*/