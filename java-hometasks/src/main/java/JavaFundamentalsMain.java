import JavaFundamentalsMain.AppLauncher;
//import java.util.Arrays; // For alternative ReverseArgumentsTask option

public class JavaFundamentalsMain {
    public static void main(String[] args) {
        do {    // the option to launch tasks multiple times
            AppLauncher.chooseYourTask(args);
            System.out.print("\n\nShould we execute some other task?" +
                    "\nEnter \"y\" or \"Y\" to choose one more task. Enter anything else to exit the program: ");
        } while (System.console().readLine().equalsIgnoreCase("y"));
        System.out.println("Have a nice day!\n\n");
        System.exit(0);
    }
}