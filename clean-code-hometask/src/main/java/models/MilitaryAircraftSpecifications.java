package models;

public enum MilitaryAircraftSpecifications {
  B_1B_LANCER("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
  B_2_SPIRIT("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
  B_52_STRATOFORTRESS("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
  F_15("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
  F_22("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
  C_130_HERCULES("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT);

  public String model;
  public int maxSpeed;
  public int maxFlightDistance;
  public int maxLoadCapacity;
  public MilitaryType type;

  MilitaryAircraftSpecifications(
      String model,
      int maxSpeed,
      int maxFlightDistance,
      int maxLoadCapacity,
      MilitaryType type) {
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.maxFlightDistance = maxFlightDistance;
    this.maxLoadCapacity = maxLoadCapacity;
    this.type = type;
  }
}
