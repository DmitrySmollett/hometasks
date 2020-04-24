package planes;

import java.util.Objects;
import models.ExperimentalAircraftSpecifications;
import models.MilitaryAircraftSpecifications;
import models.PassengerAircraftSpecifications;

abstract public class Plane {

  String model;
  private int maxSpeed;
  private int maxFlightDistance;
  private int maxLoadCapacity;

  public Plane(PassengerAircraftSpecifications aircraft) {
    this.model = aircraft.model;
    this.maxSpeed = aircraft.maxSpeed;
    this.maxFlightDistance = aircraft.maxFlightDistance;
    this.maxLoadCapacity = aircraft.maxLoadCapacity;
  }

  public Plane(MilitaryAircraftSpecifications aircraft) {
    this.model = aircraft.model;
    this.maxSpeed = aircraft.maxSpeed;
    this.maxFlightDistance = aircraft.maxFlightDistance;
    this.maxLoadCapacity = aircraft.maxLoadCapacity;
  }

  public Plane(ExperimentalAircraftSpecifications aircraft) {
    this.model = aircraft.model;
    this.maxSpeed = aircraft.maxSpeed;
    this.maxFlightDistance = aircraft.maxFlightDistance;
    this.maxLoadCapacity = aircraft.maxLoadCapacity;
  }

  public String getModel() {
    return model;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public int getMaxFlightDistance() {
    return maxFlightDistance;
  }

  public int getMaxLoadCapacity() {
    return maxLoadCapacity;
  }

  @Override
  public String toString() {
    return "Plane{"
        + "model='" + model + '\''
        + ", maxSpeed=" + maxSpeed
        + ", maxFlightDistance=" + maxFlightDistance
        + ", maxLoadCapacity=" + maxLoadCapacity + '}';
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object instanceof Plane) {
      Plane plane = (Plane) object;
      return maxSpeed == plane.maxSpeed
          && maxFlightDistance == plane.maxFlightDistance
          && maxLoadCapacity == plane.maxLoadCapacity
          && Objects.equals(model, plane.model);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
  }
}
