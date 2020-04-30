package collectionsoptional;

import collectionsmain.ConsoleReader;
import java.util.ArrayDeque;

public class ReversedNumber {
  public static void main(String[] args) {
    System.out.print("Please, enter a number: ");
    Integer number = ConsoleReader.toInt();
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (Character digit : number.toString().toCharArray()) {
      stack.push(digit);
    }
    System.out.print("\nIt's - ");
    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
    System.out.println("!\n");
  }
}
