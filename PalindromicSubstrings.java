public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        return countSubstringsRec(s, 0);
    }

    private int countSubstringsRec(String s, int start) {
        int N = s.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    private boolean isPalindromic(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        int count = ps.countSubstrings("aaa");
        System.out.println(count);
    }
}
