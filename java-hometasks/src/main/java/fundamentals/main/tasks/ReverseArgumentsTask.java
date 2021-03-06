package fundamentals.main.tasks;

import fundamentals.main.AppLauncher;

public class ReverseArgumentsTask {
  public static void main(String[] args) {}

  public static void run() {
    System.out.print("\nReversed arguments looks like: ");
    String[] cmd = AppLauncher.getArguments();
    for (int i = 0; i < cmd.length; i++) {
      System.out.print(" \"" + cmd[(cmd.length - 1) - i] + "\"");
    }
    System.out.println();
  }
}
