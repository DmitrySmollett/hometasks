package planes;

import models.MilitaryAircraftSpecifications;
import models.MilitaryType;
import java.util.Objects;

public class MilitaryPlane extends Plane {

  private MilitaryType type;

  public MilitaryPlane(MilitaryAircraftSpecifications aircraft) {
    super(aircraft);
    this.type = aircraft.type;
  }

  public MilitaryType getType() {
    return type;
  }

  @Override
  public String toString() {
    return super.toString().replace("}", ", type=" + type + '}');
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof MilitaryPlane)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    return type == ((MilitaryPlane) object).type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), type);
  }
}
