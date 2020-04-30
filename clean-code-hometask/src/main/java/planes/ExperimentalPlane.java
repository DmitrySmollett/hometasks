package planes;

import models.ClassificationLevel;
import models.ExperimentalAircraftSpecifications;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane {

  private ExperimentalTypes type;
  private ClassificationLevel classificationLevel;

  public ExperimentalPlane(ExperimentalAircraftSpecifications aircraft) {
    super(aircraft);
    this.type = aircraft.type;
    this.classificationLevel = aircraft.classificationLevel;
  }

  public ClassificationLevel getClassificationLevel() {
    return classificationLevel;
  }

  public void setClassificationLevel(ClassificationLevel classificationLevel) {
    this.classificationLevel = classificationLevel;
  }

  @Override
  public String toString() {
    return "experimentalPlane{" + "model='" + model + '\'' + '}';
  }
}
