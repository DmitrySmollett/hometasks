package collections.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSorter {
  public static void main(String[] args) {
    List<Integer> numbers =
        new ArrayList<>(Arrays.asList(3, 4, -24, 52, -12, -23, 0, 1, -5, 101, -33, 42, 17));
    System.out.println(numbers.toString());
    System.out.println();
    numbers.sort((o1, o2) -> o2 - o1);
    System.out.println(numbers.toString());
    System.out.println();

    //    In the case if sorting isn't allowed

    //    List<Integer> numbers = new
    // ArrayList<>(Arrays.asList(3,4,-24,5,-12,-23,0,1,-5,101,-33,-42,17));
    //    System.out.println(numbers.toString());
    //    System.out.println();
    //    for (int i = 0, iterations = 0; iterations < numbers.size()-1; i++, iterations++) {
    //      if (numbers.get(i) < 0 ) {
    //        numbers.add(numbers.get(i));
    //        numbers.remove(i);
    //        i--;
    //      }
    //    }
    //    System.out.println(numbers.toString());
    //    System.out.println();
  }
}
