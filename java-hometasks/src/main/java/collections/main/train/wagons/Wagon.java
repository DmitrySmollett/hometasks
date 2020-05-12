package collections.main.train.wagons;

import java.io.Serializable;

public abstract class Wagon implements Serializable {
  private int length;
  private int weight;

  public Wagon() {}

  public int getLength() {
    return length;
  }

  public int getWeight() {
    return weight;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Wagon)) {
      return false;
    }
    Wagon wagon = (Wagon) object;
    return length == wagon.length && weight == wagon.weight;
  }

  @Override
  public int hashCode() {
    int hash = 17 + length;
    hash = 31 * hash + weight;
    return hash;
  }

  @Override
  public String toString() {
    return "Wagon length=" + length + ", weight=" + weight;
  }
}
