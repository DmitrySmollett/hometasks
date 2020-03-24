package JavaFundamentalsMain;

import JavaFundamentalsMain.Tasks.*;

public class AppLauncher {
    public static void main(String[] args) {}
    private static String[] cmdArguments;
    public static String[] getArguments() {

        return cmdArguments;
    }
    public static void chooseYourTask(String[] args) {
        cmdArguments = args;
        System.out.print("\nPlease, choose which task should be executed:" +
                "\n 1 - The greetings one" +
                "\n 2 - Reverse arguments" +
                "\n 3 - Random numbers" +
                "\n 4 - Sum/multiplication of the command line arguments" +
                "\n 5 - Number -> month conversion" +
                "\nEnter a number from 1 to 5 to choose one of the tasks. Enter 0 to close the application. Your choice: ");
        boolean keepAsking = true;
        do {
            String choice = System.console().readLine();
            switch (choice) {
                case "1":
                    GreetingsTask.run();
                    keepAsking = false;
                    break;
                case "2":
                    ReverseArgumentsTask.run();
                    keepAsking = false;
                    break;
                case "3":
                    RandNumbersTask.run();
                    keepAsking = false;
                    break;
                case "4":
                    SumMultiplyTask.run();
                    keepAsking = false;
                    break;
                case "5":
                    NumToMonthConversionTask.run();
                    keepAsking = false;
                    break;
                case "0":
                    System.out.println("Have a nice day!\n\n");
                    System.exit(0); //return; to main loop as an alternative
                    break;
                default:
                    System.out.print("\nThere is no such option. Please, enter the correct number: ");
                    keepAsking = true;
                    break;
            }
        } while (keepAsking);






    }
}
