package collectionsmain.train;

import collectionsmain.train.wagons.PassengerCarriage;
import java.util.List;

public class PassengerTrain extends Train {
  List<PassengerCarriage> wagons;

  public PassengerTrain() {}

  public List<PassengerCarriage> getWagons() {
    return wagons;
  }

  public void setWagons(List<PassengerCarriage> wagons) {
    this.wagons = wagons;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof PassengerTrain)) {
      return false;
    }
    if (!(super.equals(object))) {
      return false;
    }
    return wagons.equals(((PassengerTrain) object).wagons);
  }

  @Override
  public int hashCode() {
    return 31 * super.hashCode() + wagons.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder passengerCarriage = new StringBuilder();
    wagons.forEach(obj -> passengerCarriage.append(obj.toString()));
    return "Passenger train number - " + getNumber()
        + " Locomotive model - " + getLocomotiveModel()
        + ". Wagons: \n" + passengerCarriage;
  }
}
