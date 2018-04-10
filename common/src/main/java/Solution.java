import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The sample code which could be used as a template for hackerrank java code.
 * This particular implementation just reads lines from input and writes them to output reversed.
 * By default uses System.in and System.out but allows to override both for testing purposes.
 */
final class Solution {
    private static InputStream in;
    private static Scanner scanner;
    private static PrintStream out;
    private Solution() {
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
        Solution.in = in;
        Solution.out = out;
    }

    public static void main(String[] args) {
        setupIo();
        boolean isFirstLine = true;
        while (scanner.hasNextLine()) {
            if (!isFirstLine) {
                out.println();
            }
            isFirstLine = false;
            out.print(reverseString(scanner.nextLine()));
        }
        scanner.close();
        out.close();
    }

    private static String reverseString(String str) {
        return new StringBuffer(str).reverse().toString();
    }
}
