package collectionsmain;

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
        System.out.print(
            "\nIt either too big or not an actual number. Please, enter another one: ");
      }
    } while (keepAsking);
    return number;
  }
}
