class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        if (m > n) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < n; right++) {

            // EXPAND
            windowFreq[s2.charAt(right) - 'a']++;

            // Fixed-size window reached
            if (right - left + 1 == m) {

                // PROCESS
                if (matches(s1Freq, windowFreq)) {
                    return true;
                }

                // SHRINK
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}