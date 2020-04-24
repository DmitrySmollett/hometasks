import static models.ExperimentalAircraftSpecifications.*;
import static models.MilitaryAircraftSpecifications.*;
import static models.PassengerAircraftSpecifications.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.Arrays;
import java.util.List;

public class AirportTest {

  private static List<Plane> planes = Arrays.asList(
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
      new MilitaryPlane(C_130_HERCULES),
      new ExperimentalPlane(BELL_X_14),
      new ExperimentalPlane(RYAN_X_13_VERTIJET)
  );

  @Test
  public void GetMilitaryTransportPlanesHasAtLeastOneTransport() {
    Airport airport = new Airport(planes);
    List<MilitaryPlane> transportMilitaryPlanes = airport.getMilitaryTransportPlanes();
    Assert.assertTrue(
        transportMilitaryPlanes.stream().anyMatch(o -> o.getType() == MilitaryType.TRANSPORT));
  }

  private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane(BOEING_747);

  @Test
  public void GetPassengerPlaneWithMaxPassengersCapacityReturnsBoeing747() {
    Airport airport = new Airport(planes);
    PassengerPlane expectedPlaneWithMaxPassengersCapacity =
        airport.getPassengerPlaneWithMaxPassengersCapacity();
    Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
  }

  @Test
  public void SortByMaxLoadCapacityHasAscendingSortingOrder() {
    Airport airport = new Airport(planes);
    List<? extends Plane> planesSortedByMaxLoadCapacity =
        airport.sortByMaxLoadCapacity().getPlanes();
    Assert.assertEquals(planesSortedByMaxLoadCapacity, planesSortedByMaxLoadCapacity.stream()
        .sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity)).collect(Collectors.toList()));
  }

  @Test
  public void GetMilitaryBomberPlanesHasAtLeastOneBomber() {
    Airport airport = new Airport(planes);
    List<MilitaryPlane> bomberMilitaryPlanes = airport.getMilitaryBomberPlanes();
    Assert.assertTrue(
        bomberMilitaryPlanes.stream().anyMatch(o -> o.getType() == MilitaryType.BOMBER));
  }

  @Test
  public void AtLeastOneOfExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
    Airport airport = new Airport(planes);
    List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
    Assert.assertTrue(
        experimentalPlanes.stream()
            .anyMatch(o -> o.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED));
  }
}
