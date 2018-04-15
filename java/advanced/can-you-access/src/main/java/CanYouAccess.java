import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.security.Permission;

final class CanYouAccess {
    private static InputStream in;
    private static Scanner scanner;
    private static PrintStream out;

    private CanYouAccess() {
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
        CanYouAccess.in = in;
        CanYouAccess.out = out;
    }

    public static void main(String[] args) throws Exception {

        DoNotTerminate.forbidExit();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private}
            // --------------------------------------------------------------------------------
            // CUSTOM CODE COPY PASTE BOUNDARY
            // When copy-pasting into online editor, change out to System.out

            Class inner = Inner.class;
            Class[] declaredClasses = inner.getDeclaredClasses();
            Class privateClass = declaredClasses[0];
            Constructor[] constructors = privateClass.getDeclaredConstructors();
            Constructor constructor = constructors[0];
            constructor.setAccessible(true);
            o = constructor.newInstance(new Inner());
            Method[] methods = privateClass.getDeclaredMethods();
            Method powerof2 = null;
            for (int i=0;i<methods.length;i++){
                if (methods[i].getName().equals("powerof2")){
                    powerof2 = methods[i];
                    break;
                }
            }
            powerof2.setAccessible(true);
            String text = (String)powerof2.invoke(o, num);
            out.printf("%d is %s", num, text);
            out.println();

            // CUSTOM CODE COPY PASTE BOUNDARY
            // --------------------------------------------------------------------------------
            out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
