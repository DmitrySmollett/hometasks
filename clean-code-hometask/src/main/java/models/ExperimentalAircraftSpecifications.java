package models;

public enum ExperimentalAircraftSpecifications {
  BELL_X_14(
      "Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
  RYAN_X_13_VERTIJET(
      "Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET);

  public String model;
  public int maxSpeed;
  public int maxFlightDistance;
  public int maxLoadCapacity;
  public ExperimentalTypes type;
  public ClassificationLevel classificationLevel;

  ExperimentalAircraftSpecifications(
      String model,
      int maxSpeed,
      int maxFlightDistance,
      int maxLoadCapacity,
      ExperimentalTypes type,
      ClassificationLevel classificationLevel) {
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.maxFlightDistance = maxFlightDistance;
    this.maxLoadCapacity = maxLoadCapacity;
    this.type = type;
    this.classificationLevel = classificationLevel;
  }
}
