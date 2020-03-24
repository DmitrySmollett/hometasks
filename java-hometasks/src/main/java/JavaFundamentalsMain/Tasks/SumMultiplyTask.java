package JavaFundamentalsMain.Tasks;

import JavaFundamentalsMain.AppLauncher;

public class SumMultiplyTask {
    public static void main(String[] args) {}
    public static void run () {
        int sum = 0;
        int multiply = 1;
        String[] arguments = AppLauncher.getArguments();
        for (String i : arguments)
        {
            sum += Integer.parseInt(i);
            multiply *= Integer.parseInt(i);
        }
        System.out.println("\nThe sum of the arguments is: " + sum + "\nЕhe result of multiplying the arguments is: " + multiply);
    }
}
