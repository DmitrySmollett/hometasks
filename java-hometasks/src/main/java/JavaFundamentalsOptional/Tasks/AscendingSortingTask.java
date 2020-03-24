package JavaFundamentalsOptional.Tasks;

import JavaFundamentalsOptional.PrintDoubleArray;

import java.util.Random;

public class AscendingSortingTask {
    private static Random rand = new Random();
    public static void main(String[] args) {}
    public static void run () {
        System.out.print("\nPlease, enter array size + maximum value.\nArray size: ");
        int arrSize = Integer.parseUnsignedInt(System.console().readLine());
        System.out.print("Maximum value of a randomly generated number: ");
        int max = Integer.parseUnsignedInt(System.console().readLine());
        Integer [][] array = new Integer [arrSize][arrSize];
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                array[i][j] = rand.nextInt(max*2 + 1) - max;
            }
        }
        System.out.println("\nInitial array:");
        PrintDoubleArray.printDArray(array);

        System.out.print("\nHow shall we sort this one?" +
                "\nEnter \"c\" or \"C\" to sort array based on a chosen column. Enter anything else to sort by chosen line: ");
        if (System.console().readLine().equalsIgnoreCase("c")) {
            System.out.print("\nChoose a column from 1 to " + array.length + " : ");
            int targetColumn = Integer.parseUnsignedInt(System.console().readLine()) - 1;
            boolean continueSorting;
            do {
                continueSorting = false;
                Integer[] swap;
                for(int i=1; i < array.length; i++) {
                    if(array[i-1][targetColumn] > array[i][targetColumn]) {
                        swap = array[i];
                        array[i] = array[i-1];
                        array[i-1] = swap;
                        continueSorting = true;
                    }
                }
            } while (continueSorting);
        }
        else {
            System.out.print("\nChoose a line from 1 to " + array.length + " : ");
            int targetLine = Integer.parseUnsignedInt(System.console().readLine()) - 1;
            boolean continueSorting;
            do {
                continueSorting = false;
                Integer swap;
                for(int j=1; j < array.length; j++) {

                    if(array[targetLine][j-1] > array[targetLine][j]) {
                        for (int i = 0; i < array.length; i++) {
                            swap = array[i][j];
                            array[i][j] = array[i][j-1];
                            array[i][j-1] = swap;
                        }
                        continueSorting = true;
                    }
                }
            } while (continueSorting);

        }
        System.out.println("\nRenewed array:");
        PrintDoubleArray.printDArray(array);

    }
}
