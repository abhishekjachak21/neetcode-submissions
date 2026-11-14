
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int[]rw: dp) Arrays.fill(rw, -1);

        return fun(text1, text2, 0, 0, dp);
    
    }

    static int fun(String a, String b, int i, int j, int[][] dp) {

        // base case (Agar koi string khatam ho gayi)
        if (i == a.length() || j == b.length()) {
            return 0;
        }
        
        //already calculted
        if(dp[i][j] != -1) return dp[i][j];

        // Characters match
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + fun(a, b, i + 1, j + 1, dp); 
            //wait till baki char ka ans ni ata
        }

        // Characters don't match
        int skipA = fun(a, b, i + 1, j, dp);
        int skipB = fun(a, b, i, j + 1, dp);

        return dp[i][j] = Math.max(skipA, skipB);
    }
}

/*

Har recursive call apna kaam karta hai aur baaki ka answer next recursive call se mangta hai.

LCS mein:
- Match hua: 1 + fun(...) — ek match apna, baaki recursion ka.
- Mismatch hua: Math.max(...) — dono possibilities try karo, best answer lo.
- Base case: 0 — ab kuch bacha hi nahi.
Aur sabse important: Recursive calls jab return hote hain, tab pending calculations complete hoti hain.
*/