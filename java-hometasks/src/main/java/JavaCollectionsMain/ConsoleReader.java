package JavaCollectionsMain;

public class ConsoleReader {
  public static int toInt() {
    boolean keepAsking;
    int number = 0;
    do {
      try {
        number = Integer.parseUnsignedInt(System.console().readLine());
        keepAsking = false;
      } catch (NumberFormatException typo) {
        keepAsking = true;
        System.out.print("\nIt doesn't look like a number. Please, enter an actual number: ");
      }
    } while (keepAsking);
    return number;
  }
}
