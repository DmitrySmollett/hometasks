package fundamentalsmain.tasks;

import java.time.DateTimeException;
import java.time.Month;

public class NumToMonthConversionTask {
  public static void main(String[] args) {}

  public static void run() {
    Month month;
    System.out.print("\nPlease, enter the of the month(1-12) and press Enter: ");
    boolean askAgain;
    do {
      try {
        month = Month.of(Integer.parseUnsignedInt(System.console().readLine()));
        System.out.println("\nIt's " + month + "!");
        askAgain = false;
      } catch (IllegalArgumentException | DateTimeException typo) {
        askAgain = true;
        System.out.print(
            "\nIt doesn't look like a correct number. Please, enter a number from 1 to 12: ");
      }
    } while (askAgain);
  }
}
