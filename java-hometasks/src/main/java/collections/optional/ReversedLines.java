package collections.optional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReversedLines {
  public static void main(String[] args) {
    Deque<String> fileLines = new ArrayDeque<>();
    try (BufferedReader bufferedReader =
        new BufferedReader(new FileReader("data/CollectionsReverseLines.txt"))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        fileLines.push(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(fileLines.toString());
    try (BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter("data/CollectionsReverseLines.txt"))) {
      while (!fileLines.isEmpty()) {
        bufferedWriter.write(fileLines.pop());
        bufferedWriter.newLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
