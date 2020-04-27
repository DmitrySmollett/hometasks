package JavaCollectionsMain;

import JavaCollectionsMain.Trains.PassengerTrain;
import JavaCollectionsMain.Wagons.PassengerCarriage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {

  public static void savePassengerTrainToFile (PassengerTrain passengerTrain, String outputStreamFile) {
    try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
        new FileOutputStream(outputStreamFile)))) {
      xmlEncoder.writeObject(passengerTrain);
      xmlEncoder.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static PassengerTrain loadPassengerTrainFromFile(String inputStreamFile) {
    PassengerTrain passengerTrain = new PassengerTrain();
    try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
        new FileInputStream(inputStreamFile)))) {
      passengerTrain = (PassengerTrain) xmlDecoder.readObject();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return passengerTrain;
  }

  public static int getTotalPassengers (PassengerTrain passengerTrain) {
    int passengers = 0;
    for (PassengerCarriage wagon : passengerTrain.getWagons()) {
      passengers += wagon.getPassengers();
    }
    return passengers;
  }

  public static int getTotalLuggage (PassengerTrain passengerTrain) {
    int luggage = 0;
    for (PassengerCarriage wagon: passengerTrain.getWagons()) {
      luggage += wagon.getLuggage();
    }
    return luggage;
  }

  public static PassengerTrain sortPassengerWagonsByTravelClass(PassengerTrain passengerTrain) {
    passengerTrain.getWagons().sort(
            Comparator.comparing(PassengerCarriage::getTravelClassIndex)
                .thenComparingInt(PassengerCarriage::getPassengers));
    return passengerTrain;
  }

  public static List<PassengerCarriage> filterPassengerWagonsByTheNumberOfPassengers(PassengerTrain passengerTrain) {
    int lowRange;
    int highRange;
    System.out.println("Please choose the amount of passengers");
    System.out.print("At least - ");
    lowRange = ConsoleReader.toInt();
    System.out.print("At most - ");
    highRange = ConsoleReader.toInt();
    List<PassengerCarriage> filteredWagons = new ArrayList<>();
    for (PassengerCarriage wagon: passengerTrain.getWagons()) {
      if (wagon.getPassengers() >= lowRange && wagon.getPassengers() <= highRange) {
        filteredWagons.add(wagon);
      }
    }
    return filteredWagons;
  }

}
