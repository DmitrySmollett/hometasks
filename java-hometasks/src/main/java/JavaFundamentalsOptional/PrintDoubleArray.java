package JavaFundamentalsOptional;

public class PrintDoubleArray {
    public static void main(String[] args) {}

    public static void printDArray(Integer[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%10d", array[i][j]);
            }
            System.out.println();
        }
    }
}