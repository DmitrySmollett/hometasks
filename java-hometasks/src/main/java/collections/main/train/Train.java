package collections.main.train;

import java.io.Serializable;

public class Train implements Serializable {
  private int number;
  private String locomotiveModel;

  public Train() {}

  public int getNumber() {
    return number;
  }

  public String getLocomotiveModel() {
    return locomotiveModel;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setLocomotiveModel(String locomotiveModel) {
    this.locomotiveModel = locomotiveModel;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Train)) {
      return false;
    }
    Train train = (Train) object;
    return number == train.number && locomotiveModel.equals(train.getLocomotiveModel());
  }

  @Override
  public int hashCode() {
    int hash = 17 + number;
    hash = 31 * hash + locomotiveModel.hashCode();
    return hash;
  }

  @Override
  public String toString() {
    return "Train number='" + number + '\'' + " Locomotive model -" + locomotiveModel;
  }
}
