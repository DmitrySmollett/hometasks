package planes;

import java.util.Objects;
import models.PassengerAircraftSpecifications;

public class PassengerPlane extends Plane{

  private int passengersCapacity;

  public PassengerPlane(PassengerAircraftSpecifications aircraft) {
    super(aircraft);
    this.passengersCapacity = aircraft.passengersCapacity;
  }

  public int getPassengersCapacity() {
    return passengersCapacity;
  }

  @Override
  public String toString() {
    return super.toString().replace("}", ", passengersCapacity=" + passengersCapacity + '}');
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof PassengerPlane)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    return passengersCapacity == ((PassengerPlane) object).passengersCapacity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), passengersCapacity);
  }
}
