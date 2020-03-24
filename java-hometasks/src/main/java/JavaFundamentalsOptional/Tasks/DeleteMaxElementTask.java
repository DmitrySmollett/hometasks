package JavaFundamentalsOptional.Tasks;

import JavaFundamentalsOptional.PrintDoubleArray;

import java.util.Random;

public class DeleteMaxElementTask {
    public static void main(String[] args) {}
    private static Random rand = new Random();
    public static void run () {
        System.out.print("\nPlease, enter array size + maximum value.\nArray size: ");
        int arrSize = Integer.parseUnsignedInt(System.console().readLine());
        System.out.print("Maximum value of a randomly generated number: ");
        int maxPossibleNumber = Integer.parseUnsignedInt(System.console().readLine());
        Integer [][] array = new Integer [arrSize][arrSize];
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                array[i][j] = rand.nextInt(maxPossibleNumber*2 + 1) - maxPossibleNumber;
            }
        }
        System.out.println("\nInitial array:");
        PrintDoubleArray.printDArray(array);
        int maxInArray = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > maxInArray)
                    maxInArray = array[i][j];
            }
        }
        int marker = maxPossibleNumber + 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == maxInArray) {
                    for (int k = 0; k < array.length; k++) {
                        if (array[i][k] != maxInArray)
                            array[i][k] = marker;
                        if (array[k][j] != maxInArray)
                            array[k][j] = marker;
                    }
                    array[i][j] = marker;
                }


            }
        }
        System.out.println("\nMapping numbers for deletion (max+1 value) :");
        PrintDoubleArray.printDArray(array);
        int linesLeft = array.length;
        int columnsLeft = array.length;
        for (int i = 0; i < array.length; i++) {
            boolean lineDeleted = true;
            boolean columnDeleted = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != marker)
                    lineDeleted = false;
                if (array[j][i] != marker)
                    columnDeleted = false;
            }
            if (lineDeleted)
                linesLeft -= 1;
            if (columnDeleted)
                columnsLeft -= 1;
        }
        System.out.println("\n " + linesLeft + " lines and " + columnsLeft + " columns left");
        Integer[][] newArray = new Integer[linesLeft][columnsLeft];
        int newArrayLine = 0;
        int newArrayColumn = 0;
        boolean nextLine = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != marker) {
                    newArray[newArrayLine][newArrayColumn] = array[i][j];
                    newArrayColumn += 1;
                    nextLine = true;
                }
            }
            newArrayColumn = 0;
            if (nextLine)
                newArrayLine += 1;
            nextLine = false;
        }


        System.out.println("\nRenewed array:");
        PrintDoubleArray.printDArray(newArray);

    }
}
