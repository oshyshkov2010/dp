import java.util.Arrays;

public class StoneGameMemo {
    public boolean stoneGame(int[] piles) {
        int total = Arrays.stream(piles).sum();

        int[][] cache = new int[piles.length][piles.length];
        int firstScore = countOptimalPiles(piles, 0, piles.length - 1, cache);
        int secondScore = total - firstScore;
        return firstScore > secondScore;
    }

    private int countOptimalPiles(int[] piles, int start, int end, int[][] cache) {
        if (start >= end) return 0;

        if (cache[start][end] > 0) {
            return cache[start][end];
        }

        int maxLeft = piles[start] + Math.min(countOptimalPiles(piles, start + 2, end, cache),
                countOptimalPiles(piles, start + 1, end - 1, cache));

        int maxRight = piles[end] + Math.min(countOptimalPiles(piles, start, end - 2, cache),
                countOptimalPiles(piles, start + 1, end - 1, cache));

        cache[start][end] = Math.max(maxLeft, maxRight);
        return cache[start][end];
    }

    public static void main(String[] args) {
        StoneGameMemo game = new StoneGameMemo();

        game.stoneGame(new int[] {5,3,4,5} );
    }
}
