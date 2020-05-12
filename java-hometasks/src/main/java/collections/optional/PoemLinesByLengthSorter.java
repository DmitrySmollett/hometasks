package collections.optional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PoemLinesByLengthSorter {
  public static void main(String[] args) {
    List<String> poem = new ArrayList<>();
    poem.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
    poem.add("Ut pharetra augue at neque vehicula, in dictum ante congue.");
    poem.add("Suspendisse rutrum leo eu ipsum auctor eleifend.");
    poem.add("Ut porta tellus non elit aliquam ultrices.");
    System.out.println("Initial\n");
    poem.forEach(System.out::println);
    System.out.println("\nSorted by the line length\n");
    poem.sort(Comparator.comparingInt(String::length));
    poem.forEach(System.out::println);
    System.out.println();
  }
}
