package JavaCollectionsMain.Types;

public enum TravelClass {
  FIRST_CLASS(1), ECONOMY_CLASS(2);

  private int classIndexFromBestToWorst;

  public int getClassIndex() {
    return classIndexFromBestToWorst;
  }

  TravelClass(int classIndex) {
    this.classIndexFromBestToWorst = classIndex;
  }
}
