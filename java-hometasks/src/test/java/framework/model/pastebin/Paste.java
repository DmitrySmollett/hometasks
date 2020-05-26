package framework.model.pastebin;

import java.util.Objects;

public class Paste {
  private String paste;
  private String titleOfThePaste;

  public Paste(String paste, String titleOfThePaste) {
    this.paste = paste;
    this.titleOfThePaste = titleOfThePaste;
  }

  public String getPaste() {
    return paste;
  }

  public void setPaste(String paste) {
    this.paste = paste;
  }

  public String getTitleOfThePaste() {
    return titleOfThePaste;
  }

  public void setTitleOfThePaste(String titleOfThePaste) {
    this.titleOfThePaste = titleOfThePaste;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paste paste1 = (Paste) o;
    return paste.equals(paste1.paste) && titleOfThePaste.equals(paste1.titleOfThePaste);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paste, titleOfThePaste);
  }

  @Override
  public String toString() {
    return "Paste{" +
        "paste='" + paste + '\'' +
        ", titleOfThePaste='" + titleOfThePaste + '\'' +
        '}';
  }
}
