import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

final class JavaStringTokens {
    private static InputStream in;
    private static Scanner scanner;
    private static PrintStream out;

    private JavaStringTokens() {
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
        JavaStringTokens.in = in;
        JavaStringTokens.out = out;
    }

    public static void main(String[] args) {
        setupIo();
        String s = scanner.nextLine().trim();
        String[] tokens = s.split("[ !,?._'@]+");
        int len = tokens.length;
        if (tokens.length > 0 && tokens[0].length() == 0) {
            len -= 1;
        }
        out.print(len);
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() == 0) {
                continue;
            }
            out.println();
            out.print(tokens[i]);
        }
        scanner.close();
    }
}
