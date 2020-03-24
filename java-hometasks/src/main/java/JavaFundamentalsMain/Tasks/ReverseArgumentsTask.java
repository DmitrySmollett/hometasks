package JavaFundamentalsMain.Tasks;


//import java.util.Arrays; // For alternative ReverseArgumentsTask option
//import java.util.Collections; // For alternative ReverseArgumentsTask option
import JavaFundamentalsMain.AppLauncher;

public class ReverseArgumentsTask {
    public static void main(String[] args) {}
    public static void run () {
        System.out.print("\nReversed arguments looks like: ");
        String[] cmd = AppLauncher.getArguments();
        for (int i = 0; i < cmd.length; i++) {
            System.out.print(" \"" + cmd[(cmd.length-1)-i] + "\"");
        }
        System.out.println();

//        Alternative overkill option
//        String[] newCmd = Arrays.copyOf(cmd,cmd.length);
//        Collections.reverse(Arrays.asList(newCmd));
//        System.out.println(Arrays.asList(newCmd));

    }
}
