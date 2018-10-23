public class MaxCommonSubstringDp {
    public int findMaxSubstring(String s1, String s2) {
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];

        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                    max = Math.max(max, cache[i][j]);
                } else {
                    cache[i][j] = 0;
                }
            }
        }
        
        return max;
    }
}
