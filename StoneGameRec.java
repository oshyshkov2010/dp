import java.util.Arrays;

public class StoneGameRec {

    public boolean stoneGame(int[] piles) {
        int total = Arrays.stream(piles).sum();
        int firstScore = countOptimalPiles(piles, 0, piles.length - 1);
        int secondScore = total - firstScore;
        return firstScore > secondScore;
    }

    private int countOptimalPiles(int[] piles, int start, int end) {
        System.out.println("start=" + start + " end=" + end);
        if (start >= end) return 0;

        int maxLeft = piles[start] + Math.min(countOptimalPiles(piles, start + 2, end),
                countOptimalPiles(piles, start + 1, end - 1));

        int maxRight = piles[end] + Math.min(countOptimalPiles(piles, start, end - 2),
                countOptimalPiles(piles, start + 1, end - 1));

        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        StoneGameRec game = new StoneGameRec();

        game.stoneGame(new int[] {5,3,4,5} );
    }
}
