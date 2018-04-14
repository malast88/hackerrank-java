import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

final class Java1DArray {
    private static InputStream in;
    private static Scanner scanner;
    private static PrintStream out;

    private Java1DArray() {
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
        Java1DArray.in = in;
        Java1DArray.out = out;
    }

    public static void main(String[] args) {
        setupIo();
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            int leap = scanner.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scanner.nextInt();
            }

            out.print((canWin(leap, game)) ? "YES" : "NO");
            if (q > 0) {
                out.println();
            }
        }
        scanner.close();
    }

    public static boolean canWin(int leap, int[] game) {
        boolean[] cache = new boolean[game.length];
        for (int i = 0; i < game.length; i++) {
            cache[i] = true;
        }
        return canWin(leap, game, 0, cache);
    }

    public static boolean canWin(int leap, int[] game, int currIndex, boolean[] cache) {
        cache[currIndex] = false;
        if (currIndex + leap >= game.length || currIndex + 1 == game.length) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nextIndex = 0;
            switch (i) {
                case 0:
                    nextIndex = currIndex + leap;
                    break;
                case 1:
                    nextIndex = currIndex + 1;
                    break;
                case 2:
                    nextIndex = currIndex - 1;
                    break;
            }
            if (nextIndex < 0) {
                continue;
            }
            if (game[nextIndex] == 0 && cache[nextIndex]) {
                cache[nextIndex] = canWin(leap, game, nextIndex, cache);
                if (cache[nextIndex]) {
                    return true;
                }
            }
        }
        cache[currIndex] = true;
        return false;
    }
}
