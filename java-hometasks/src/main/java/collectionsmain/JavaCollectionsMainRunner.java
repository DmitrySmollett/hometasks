package collectionsmain;

import collectionsmain.train.PassengerTrain;
import collectionsmain.train.wagons.PassengerCarriage;
import java.util.List;

public class JavaCollectionsMainRunner {

  public static void main(String[] args) {
    PassengerTrain train = TrainStation.loadPassengerTrainFromFile("data/passengerTrain.xml");
    System.out.println("Initial Train\n\n" + train.toString());
    System.out.println("Passengers total - " + TrainStation.getTotalPassengers(train));
    System.out.println("Luggage total - " + TrainStation.getTotalLuggage(train) + "\n");
    System.out.println("Train with wagons sorted by Travel class -> Passengers\n");
    System.out.println(TrainStation.sortPassengerWagonsByTravelClass(train).toString());
    List<PassengerCarriage> wagons =
        TrainStation.filterPassengerWagonsByTheNumberOfPassengers(train);
    if (!wagons.isEmpty()) {
      System.out.println("\nWagons that meet passengers amount criteria:");
      wagons.forEach(obj -> System.out.print(obj.toString()));
    } else {
      System.out.println("No matches found");
    }
    System.out.println();
  }
}
