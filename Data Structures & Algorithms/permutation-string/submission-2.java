class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;

        int[] freq1 = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < m; i++) {
            freq1[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, window)) {
            return true;
        }

        for (int i = m; i < n; i++) {

            // Add new character
            window[s2.charAt(i) - 'a']++;

            // Remove old character
            window[s2.charAt(i - m) - 'a']--;

            if (Arrays.equals(freq1, window)) {
                return true;
            }
        }

        return false;
    }
}