class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      Map<String, ArrayList<String>> mp1 = new HashMap<>();

      for(String str: strs){

        char[] ch = str.toCharArray();

        Arrays.sort(ch);

        String key = new String(ch);
        
        mp1.putIfAbsent(key, new ArrayList<>());

        mp1.get(key).add(str);

      }

      return new ArrayList<>(mp1.values());

    }
}
// 18-5-2026 (2nd week 1st day) (4th day, started on 15May2026), lets see kaha tk jaate hai