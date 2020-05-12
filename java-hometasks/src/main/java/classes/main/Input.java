package classes.main;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Input {
  public static void main(String[] args) {}

  public static int toNumber(String numberDescription) {
    boolean askAgain;
    int number = 0;
    do {
      try {
        System.out.print(numberDescription);
        number = Integer.parseUnsignedInt(System.console().readLine());
        askAgain = false;
      } catch (NumberFormatException typo) {
        askAgain = true;
        System.out.print("\nIt doesn't look like a number. Please, enter an actual number: ");
      }
    } while (askAgain);
    return number;
  }

  public static LocalTime toTime(String timeDescription) {
    boolean askAgain;
    LocalTime time = LocalTime.NOON;
    do {
      try {
        System.out.print(timeDescription);
        time = LocalTime.parse(System.console().readLine());
        askAgain = false;
      } catch (DateTimeParseException typo) {
        askAgain = true;
        System.out.print(
            "\nIt doesn't look like a time. Please, enter it using next format - HH:mm ");
      }
    } while (askAgain);
    return time;
  }

  public static String toString(String stringDescription) {
    System.out.print(stringDescription);
    String input;
    input = System.console().readLine();
    return input;
  }
}
