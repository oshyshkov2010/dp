import java.util.HashMap;
import java.util.Map;

public class WaysToDecode {
    private static final int ALPHABET_SIZE = 26;

    private static Map<Integer, Character> mapping;

    static {
        mapping = new HashMap<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            mapping.put(i + 1, (char) ('a' + i));
        }
    }

    // https://www.youtube.com/watch?v=qli-JCrSwuk
    public int waysToDecode(String message) {
        int totalWays = 0;

        for (int i = 0; i < message.length(); i++) {
            int index = Integer.valueOf(message.charAt(i));
            if (mapping.containsKey(index)) {
                totalWays++;
            }

            if (i + 1 < message.length()) {
                int twoDigitIndex = Integer.valueOf(message.charAt(i) + message.charAt(i + 1));
                if (mapping.containsKey(twoDigitIndex)) {
                    totalWays++;
                }
            }
        }

        return totalWays;
    }
}
