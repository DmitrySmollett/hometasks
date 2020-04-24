import JavaFundamentalsOptional.AppLauncher;

public class JavaFundamentalsOptional {

  public static void main(String[] args) {
    do {
      AppLauncher.chooseYourTask();
      System.out.print("\n\nShould we execute some other task? \nEnter \"y\" or \"Y\" "
          + "to choose one more task. Enter anything else to exit the program: ");
    } while (System.console().readLine().equalsIgnoreCase("y"));
    System.out.println("Have a nice day!\n\n");
    System.exit(0);
  }
}
