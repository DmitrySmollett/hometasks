import static models.MilitaryAircraftSpecifications.*;
import static models.PassengerAircraftSpecifications.*;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.Arrays;
import java.util.List;

public class Runner {

  static List<Plane> planes = Arrays.asList(
          new PassengerPlane(BOEING_737),
          new PassengerPlane(BOEING_737_800),
          new PassengerPlane(BOEING_747),
          new PassengerPlane(AIRBUS_A320),
          new PassengerPlane(AIRBUS_A330),
          new PassengerPlane(EMBRAER_190),
          new PassengerPlane(SUKHOI_SUPERJET_100),
          new PassengerPlane(BOMBARDIER_CS300),
          new MilitaryPlane(B_1B_LANCER),
          new MilitaryPlane(B_2_SPIRIT),
          new MilitaryPlane(B_52_STRATOFORTRESS),
          new MilitaryPlane(F_15),
          new MilitaryPlane(F_22),
          new MilitaryPlane(C_130_HERCULES));

  public static void main(String[] args) {
    Airport airport = new Airport(planes);
    Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
    Airport passengerAirport = new Airport(airport.getPassengerPlanes());
    System.out.println(
        "Military airport sorted by max distance: "
            + militaryAirport.sortByMaxDistance().toString());
    System.out.println(
        "Passenger airport sorted by max speed: " + passengerAirport.sortByMaxSpeed().toString());
    System.out.println(
        "Plane with max passenger capacity: "
            + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
  }
}
