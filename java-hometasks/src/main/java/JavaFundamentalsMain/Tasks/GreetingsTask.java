package JavaFundamentalsMain.Tasks;

public class GreetingsTask {
  public static void main(String[] args) {}

  public static void run() {
    System.out.print("\nPlease, enter your name: ");
    String name = System.console().readLine();
    System.out.println("\nHello, " + name + "!" + "\nNice to meet you!");
  }
}
