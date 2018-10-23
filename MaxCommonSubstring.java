public class MaxCommonSubstring {
    public int findMaxSubstring(String s1, String s2) {
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int current = findLength(s1, s2, i, j);
                    max = Math.max(current, max);
                }
            }
        }

        return max;
    }

    private int findLength(String s1, String s2, int i, int j) {
        int l = 0;
        while (s1.charAt(i++) == s2.charAt(j++)) {
            l++;
        }

        return l;
    }
}
