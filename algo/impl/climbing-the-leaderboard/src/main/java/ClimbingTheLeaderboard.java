import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

final class ClimbingTheLeaderboard {
    private static InputStream in;
    private static Scanner scanner;
    private static PrintStream out;

    private ClimbingTheLeaderboard() {
    }

    private static void setupIo() {
        if (in == null) {
            in = System.in;
        }
        scanner = new Scanner(in);
        if (out == null) {
            out = System.out;
        }
    }

    public static void setInOut(InputStream in, PrintStream out) {
        ClimbingTheLeaderboard.in = in;
        ClimbingTheLeaderboard.out = out;
    }

    public static void main(String[] args) {
        setupIo();
        int leaderboardCount = scanner.nextInt();
        int[] leaderboard = new int[leaderboardCount];
        for (int i = 0; i < leaderboardCount; i++) {
            leaderboard[i] = scanner.nextInt();
        }
        int roundsCount = scanner.nextInt();
        int[] roundScores = new int[roundsCount];
        for (int i = 0; i < roundsCount; i++) {
            roundScores[i] = scanner.nextInt();
        }
        ClimbTheLeaderboard(leaderboard, roundScores);
        scanner.close();
        out.close();
    }

    private static void ClimbTheLeaderboard(int[] leaderboard, int[] roundScores) {
        int[] places = new int[leaderboard.length];
        int currPlace = 1;
        places[0] = currPlace;
        for (int i = 1; i < leaderboard.length; i++) {
            if (leaderboard[i] < leaderboard[i - 1]) {
                currPlace++;
            }
            places[i] = currPlace;
        }

        int currLeaderboardIndex = leaderboard.length - 1;
        for (int i = 0; i < roundScores.length; i++) {
            int currRoundScore = roundScores[i];
            while (currRoundScore >= leaderboard[currLeaderboardIndex] && currLeaderboardIndex > 0) {
                currLeaderboardIndex--;
            }
            int currRoundPlace = 0;
            if (currLeaderboardIndex == 0 && currRoundScore >= leaderboard[currLeaderboardIndex]) {
                currRoundPlace = 1;
            } else if (currLeaderboardIndex == leaderboard.length - 1 && currRoundScore < leaderboard[currLeaderboardIndex]) {
                currRoundPlace = places[places.length - 1] + 1;
            } else {
                currRoundPlace = places[currLeaderboardIndex + 1];
            }

            out.print(currRoundPlace);
            if (i < roundScores.length - 1) {
                out.println();
            }
        }
    }
}
