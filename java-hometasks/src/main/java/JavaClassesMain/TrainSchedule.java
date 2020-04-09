package JavaClassesMain;

import java.time.LocalTime;
import java.util.Random;

public class TrainSchedule {
    public static void main(String[] args) {}
    private static Random rand = new Random();

    public static Train[] createRandom(int length) {
        String[] destinationTemplate = {"Lviv", "Brest", "Warsaw", "Adler", "Moscow", "Vilnius", "Kiev"};
        Train[] trainArray = new Train[length];
        for (int i = 0; i < length; i++) {
            trainArray[i] = new Train();
            trainArray[i].setNumber(rand.nextInt(1000)+1);
            trainArray[i].setDestination(destinationTemplate[rand.nextInt(destinationTemplate.length)]);
            trainArray[i].setDepartureTime(LocalTime.ofSecondOfDay(rand.nextInt(86400)));
            trainArray[i].setSittingCoaches(rand.nextInt(100)+1);
            trainArray[i].setEconomyClassSleeper(rand.nextInt(100)+1);
            trainArray[i].setCompartmentSleeper(rand.nextInt(100)+1);
            trainArray[i].setBusinessClass(rand.nextInt(20)+1);
        }
        System.out.println("\nArray created.");
        return trainArray;
    }

    public static Train[] createDestinationRandom(int length) {
        Train[] trainArray = new Train[length];
        for (int i = 0; i < length; i++) {
            System.out.println("\nPlease, enter data for entry №" + (i + 1) + " ");
            trainArray[i] = new Train(Input.toString("Destination point is - "));
            trainArray[i].setNumber(rand.nextInt(1000)+1);
//            trainArray[i].setDestination(Input.Line("Destination point is - "));
            trainArray[i].setDepartureTime(LocalTime.ofSecondOfDay(rand.nextInt(86400)));
            trainArray[i].setSittingCoaches(rand.nextInt(100)+1);
            trainArray[i].setEconomyClassSleeper(rand.nextInt(100)+1);
            trainArray[i].setCompartmentSleeper(rand.nextInt(100)+1);
            trainArray[i].setBusinessClass(rand.nextInt(20)+1);
        }
        System.out.println("\nArray created.");
        return trainArray;
    }

    public static Train[] createManually(int length) {
        Train[] trainArray = new Train[length];
        for (int i = 0; i < length; i++) {
            System.out.println("\nPlease, enter data for entry №" + (i + 1) + " ");
            trainArray[i] = new Train();
            trainArray[i].setNumber(Input.toNumber("Number of the train is - "));
            trainArray[i].setDestination(Input.toString("Destination point is - "));
            trainArray[i].setDepartureTime(Input.toTime("Time of departure in format HH:mm is - "));
            trainArray[i].setSittingCoaches(Input.toNumber("Number of sitting coaches - "));
            trainArray[i].setEconomyClassSleeper(Input.toNumber("Number of economy class sleeper seats - "));
            trainArray[i].setCompartmentSleeper(Input.toNumber("Number of compartment sleeper seats - "));
            trainArray[i].setBusinessClass(Input.toNumber("Number of business class seats - "));
        }
        System.out.println("\nArray created.");
        return trainArray;
    }

    public static void printArray (Train[] train) {
        System.out.println();
        for (int i = 0; i < train.length; i++) {
            System.out.println(train[i].toString());
        }
    }

    public static void findByDestination (Train[] train) {
        System.out.print("\nPlease, enter point of destination: ");
        String destination = System.console().readLine();
        System.out.println("\nTrains that will go in that direction: ");
        boolean noResults = true;
        for (int i = 0; i < train.length; i++) {
            if (destination.equalsIgnoreCase(train[i].destination)) {
                System.out.println(train[i].toString());
                noResults = false;
            }
        }
        if (noResults)
            System.out.println("No matches found");
    }

    public static void findByDestinationHour (Train[] train) {
        System.out.print("\nPlease, enter point of destination: ");
        String destination = System.console().readLine();
        LocalTime time = Input.toTime("Please, enter time of departure in format HH:mm ");
        System.out.println("\nTrains that will go in that direction: ");
        boolean noResults = true;
        for (int i = 0; i < train.length; i++) {
            if (destination.equalsIgnoreCase(train[i].destination) && (train[i].getDepartureTime().isAfter(time))) {
                System.out.println(train[i].toString());
                noResults = false;
            }
        }
        if (noResults)
            System.out.println("No matches found");
    }

    public static void findByDestinationCompartment (Train[] train) {
        System.out.print("\nPlease, enter point of destination: ");
        String destination = System.console().readLine();
        System.out.println("\nTrains that will go in that direction and have sitting coaches: ");
        boolean noResults = true;
        for (int i = 0; i < train.length; i++) {
            if (destination.equalsIgnoreCase(train[i].destination) && train[i].getSittingCoaches() > 0 ) {
                System.out.println(train[i].toString());
                noResults = false;
            }
        }
        if (noResults)
            System.out.println("No matches found");
    }
}
