package models;

public enum PassengerAircraftSpecifications {
  BOEING_737("Boeing-737", 900, 12000, 60500, 164),
  BOEING_737_800("Boeing-737-800", 940, 12300, 63870, 192),
  BOEING_747("Boeing-747", 980, 16100, 70500, 242),
  AIRBUS_A320("Airbus A320", 930, 11800, 65500, 188),
  AIRBUS_A330("Airbus A330", 990, 14800, 80500, 222),
  EMBRAER_190("Embraer 190", 870, 8100, 30800, 64),
  SUKHOI_SUPERJET_100("Sukhoi Superjet 100", 870, 11500, 50500, 140),
  BOMBARDIER_CS300("Bombardier CS300", 920, 11000, 60700, 196);

  public String model;
  public int maxSpeed;
  public int maxFlightDistance;
  public int maxLoadCapacity;
  public int passengersCapacity;

  PassengerAircraftSpecifications(
      String model,
      int maxSpeed,
      int maxFlightDistance,
      int maxLoadCapacity,
      int passengersCapacity) {
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.maxFlightDistance = maxFlightDistance;
    this.maxLoadCapacity = maxLoadCapacity;
    this.passengersCapacity = passengersCapacity;
  }
}
