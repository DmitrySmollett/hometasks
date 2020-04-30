import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import models.MilitaryType;
import org.jetbrains.annotations.NotNull;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

public class Airport {

  private List<? extends Plane> planes;

  public Airport(List<? extends Plane> planes) {
    this.planes = planes;
  }

  public List<? extends Plane> getPlanes() {
    return planes;
  }

  public List<PassengerPlane> getPassengerPlanes() {
    List<PassengerPlane> passengerPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof PassengerPlane) {
        passengerPlanes.add((PassengerPlane) plane);
      }
    }
    return passengerPlanes;
  }

  public List<MilitaryPlane> getMilitaryPlanes() {
    List<MilitaryPlane> militaryPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof MilitaryPlane) {
        militaryPlanes.add((MilitaryPlane) plane);
      }
    }
    return militaryPlanes;
  }

  public List<ExperimentalPlane> getExperimentalPlanes() {
    List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof ExperimentalPlane) {
        experimentalPlanes.add((ExperimentalPlane) plane);
      }
    }
    return experimentalPlanes;
  }

  public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
    List<PassengerPlane> passengerPlanes = getPassengerPlanes();
    return Collections.max(
        passengerPlanes, (Comparator.comparingInt(PassengerPlane::getPassengersCapacity)));
  }

  public List<MilitaryPlane> getMilitaryBomberPlanes() {
    List<MilitaryPlane> militaryBomberPlanes = new ArrayList<>(getMilitaryPlanes());
    militaryBomberPlanes.removeIf(plane -> plane.getType() != MilitaryType.BOMBER);
    return militaryBomberPlanes;
  }

  public List<MilitaryPlane> getMilitaryTransportPlanes() {
    List<MilitaryPlane> militaryTransportPlanes = new ArrayList<>(getMilitaryPlanes());
    militaryTransportPlanes.removeIf(plane -> plane.getType() != MilitaryType.TRANSPORT);
    return militaryTransportPlanes;
  }

  public Airport sortByMaxDistance() {
    planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    return this;
  }

  public Airport sortByMaxSpeed() {
    planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    return this;
  }

  public Airport sortByMaxLoadCapacity() {
    planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    return this;
  }

  private void print(@NotNull List<? extends Plane> list) {
    for (Plane plane : list) {
      System.out.println(plane);
    }
  }

  @Override
  public String toString() {
    return "Airport{Planes=" + planes.toString() + '}';
  }
}
