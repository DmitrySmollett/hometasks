package JavaFundamentalsMain.Tasks;

import java.util.concurrent.ThreadLocalRandom;

public class RandNumbersTask {
  public static void main(String[] args) {}

  public static void run() {
    System.out.print("\nPlease, enter how many random numbers should be there: ");
    int quantity = 0;
    boolean askAgain;
    do {
      try {
        quantity = Math.abs(Integer.parseInt(System.console().readLine()));
        if (quantity == 0) throw new Exception("Should be > 0");
        askAgain = false;
      } catch (NumberFormatException typo) {
        askAgain = true;
        System.out.print("\nIt doesn't look like a number. Please, enter an actual number: ");
      } catch (Exception typo) {
        askAgain = true;
        System.out.print(
            "\nWell. While 0 is a number, please, enter something more substantial :) ");
      }
    } while (askAgain);

    System.out.print(
        "\nBy default, numbers would be displayed in a line. "
            + "\nEnter \"v\" or \"V\" to arrange them vertically. Enter anything else to use the default option: ");
    boolean verticalArrangement = System.console().readLine().equalsIgnoreCase("v");
    System.out.println();
    if (verticalArrangement) {
      for (int i = 0; i < quantity; i++) {
        System.out.println(" " + ThreadLocalRandom.current().nextInt(0, 10_001));
      }
    } else {
      for (int i = 0; i < quantity; i++) {
        System.out.print(" " + ThreadLocalRandom.current().nextInt(0, 10_001));
      }
      System.out.println();
    }
  }
}
