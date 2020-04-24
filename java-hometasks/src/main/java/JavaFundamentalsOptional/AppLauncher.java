package JavaFundamentalsOptional;

import JavaFundamentalsOptional.Tasks.AscendingSortingTask;
import JavaFundamentalsOptional.Tasks.DeleteMaxElementTask;

public class AppLauncher {
  public static void main(String[] args) {}

  public static void chooseYourTask() {
    System.out.print(
        "\nPlease, choose which task should be executed:"
            + "\n 1 - Sort lines/columns by ascending order based on a certain line/column"
            + "\n 2 - Locate the maximum number in the array. Delete lines/columns that contain this number"
            + "\nEnter a number from 1 to 2 <_< to choose one of the tasks. Enter 0 to close the application. Your choice: ");
    boolean keepAsking = true;
    do {
      String choice = System.console().readLine();
      switch (choice) {
        case "1":
          AscendingSortingTask.run();
          keepAsking = false;
          break;
        case "2":
          DeleteMaxElementTask.run();
          keepAsking = false;
          break;
        case "0":
          System.out.println("Have a nice day!\n\n");
          System.exit(0);
          break;
        default:
          System.out.print("\nThere is no such option. Please, enter the correct number: ");
          keepAsking = true;
          break;
      }
    } while (keepAsking);
  }
}
