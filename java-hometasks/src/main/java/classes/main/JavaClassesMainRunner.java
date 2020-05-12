package classes.main;

public class JavaClassesMainRunner {
  public static void main(String[] args) {
    do {
      int length = Input.toNumber("Please, choose the number of trains in the array: ");
      System.out.print(
          "\nAnd choose how the array of trains should be created:"
              + "\n 1 - Everything filled with random data"
              + "\n 2 - Type destination point and fill the rest with random data"
              + "\n 3 - Fill everything manually"
              + "\nEnter a number from 1 to 3 to choose one of the tasks. Your choice: ");
      boolean keepAsking;
      Train[] array = new Train[length];
      do {
        String choice = System.console().readLine();
        switch (choice) {
          case "1":
            array = TrainSchedule.createRandom(length);
            keepAsking = false;
            break;
          case "2":
            array = TrainSchedule.createDestinationRandom(length);
            keepAsking = false;
            break;
          case "3":
            array = TrainSchedule.createManually(length);
            keepAsking = false;
            break;
          default:
            System.out.print("\nThere is no such option. Please, enter the correct number: ");
            keepAsking = true;
            break;
        }
      } while (keepAsking);

      TrainSchedule.printArray(array);

      System.out.print(
          "\nPlease, choose what should we look for:"
              + "\n 1 - All entries with similar destination point "
              + "\n 2 - All entries with similar destination point where the train departs later than specific time"
              + "\n 3 - All entries with similar destination point and sitting coaches "
              + "\nEnter a number from 1 to 3 to choose one of the tasks. Your choice: ");
      do {
        String choice = System.console().readLine();
        switch (choice) {
          case "1":
            TrainSchedule.findByDestination(array);
            keepAsking = false;
            break;
          case "2":
            TrainSchedule.findByDestinationHour(array);
            keepAsking = false;
            break;
          case "3":
            TrainSchedule.findByDestinationCompartment(array);
            keepAsking = false;
            break;
          default:
            System.out.print("\nThere is no such option. Please, enter the correct number: ");
            keepAsking = true;
            break;
        }
      } while (keepAsking);

      System.out.print(
          "\n\nShould we execute some other task?"
              + "\nEnter \"y\" or \"Y\" to choose one more task. Enter anything else to exit the program: ");
    } while (System.console().readLine().equalsIgnoreCase("y"));
    System.out.println("Have a nice day!\n\n");
    System.exit(0);
  }
}
