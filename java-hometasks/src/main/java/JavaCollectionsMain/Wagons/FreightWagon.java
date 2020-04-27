package JavaCollectionsMain.Wagons;

public class FreightWagon {
  private String model;
  private String cargoType;
  private int cargoWeight;

  public FreightWagon() {}

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getCargoType() {
    return cargoType;
  }

  public void setCargoType(String cargoType) {
    this.cargoType = cargoType;
  }

  public int getCargoWeight() {
    return cargoWeight;
  }

  public void setCargoWeight(int cargoWeight) {
    this.cargoWeight = cargoWeight;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof FreightWagon)) {
      return false;
    }
    if (!(super.equals(object))) {
      return false;
    }
    FreightWagon wagon = (FreightWagon) object;
    return cargoWeight == wagon.cargoWeight
        && model.equals(wagon.model)
        && cargoType.equals(wagon.cargoType);
  }

  @Override
  public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + cargoWeight;
    hash = 31 * hash + model.hashCode();
    hash = 31 * hash + cargoType.hashCode();
    return hash;
  }

  @Override
  public String toString() {
    return "\nModel - " + model + ", cargoType - " + cargoType + ", cargoWeight - " + cargoWeight;
  }
}
