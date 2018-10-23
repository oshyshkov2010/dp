public class MaxCommonSubstringMemo {
    public int findMaxSubstring(String s1, String s2) {
        int[][] cache = new int[s1.length()][s2.length()];
        return findMaxSubstringFrom(s1, 0, s2, 0, cache);
    }

    public int findMaxSubstringFrom(String s1, int start1, String s2, int start2, int[][] cache) {
        if (start1 == s1.length() || start2 == s2.length()) return 0;

        if (cache[start1][start2] != 0) {
            return cache[start1][start2];
        }

        int current = findLength(s1, start1, s2, start2);
        int next1 = findMaxSubstringFrom(s1, start1 + 1, s2, start2, cache);
        int next2 = findMaxSubstringFrom(s1, start1, s2, start2 + 1, cache);

        cache[start1][start2] = Math.max(current, Math.max(next1, next2));

        return cache[start1][start2];
    }

    private int findLength(String s1, int start1, String s2, int start2) {
        int l = 0;
        while (s1.charAt(start1++) == s2.charAt(start2++)) {
            l++;
        }

        return l;
    }
}
