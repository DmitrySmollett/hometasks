package JavaCollectionsMain.Wagons;

import JavaCollectionsMain.Types.TravelClass;

public class PassengerCarriage {
  private TravelClass travelClass;
  private int passengers;
  private int luggage;

  public PassengerCarriage() {}

  public TravelClass getTravelClass() {
    return travelClass;
  }

  public int getTravelClassIndex () {
    return travelClass.getClassIndex();
  }

  public int getPassengers() {
    return passengers;
  }

  public int getLuggage() {
    return luggage;
  }

  public void setTravelClass(TravelClass travelClass) {
    this.travelClass = travelClass;
  }

  public void setPassengers(int passengers) {
    this.passengers = passengers;
  }

  public void setLuggage(int luggage) {
    this.luggage = luggage;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof PassengerCarriage)) {
      return false;
    }
    if (!(super.equals(object))) {
      return false;
    }
    PassengerCarriage wagon = (PassengerCarriage) object;
    return passengers == wagon.passengers
        && luggage == wagon.luggage
        && travelClass == wagon.travelClass;
  }

  @Override
  public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + passengers;
    hash = 31 * hash + luggage;
    hash = 31 * hash + travelClass.hashCode();
    return hash;
  }

  @Override
  public String toString() {
    return String.format(
        "TravelClass - %1$-15s passengers - %2$-4d luggage - %3$-4d \n",
        travelClass, passengers, luggage);
  }
}
