package collectionsmain.train;

import collectionsmain.train.wagons.FreightWagon;
import java.util.List;

public class FreightTrain extends Train {
  List<FreightWagon> wagons;

  public FreightTrain() {}

  public List<FreightWagon> getWagons() {
    return wagons;
  }

  public void setWagons(List<FreightWagon> wagons) {
    this.wagons = wagons;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof FreightTrain)) {
      return false;
    }
    if (!(super.equals(object))) {
      return false;
    }
    return wagons.equals(((FreightTrain) object).wagons);
  }

  @Override
  public int hashCode() {
    return 31 * super.hashCode() + wagons.hashCode();
  }

  @Override
  public String toString() {
    return "Freight train number='" + getNumber() + '\''
        + " Locomotive model -" + getLocomotiveModel()
        + ". Wagons: " + wagons.toString();
  }
}
