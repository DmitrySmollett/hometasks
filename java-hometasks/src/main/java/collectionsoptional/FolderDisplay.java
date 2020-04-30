package collectionsoptional;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FolderDisplay {
  public static void main(String[] args) {
    File dir = new File(System.getProperty("user.dir"));
    if (dir.listFiles() != null) {
      List<File> files = Arrays.asList(dir.listFiles());
      for (File file : files) {
        System.out.println(file.toString());
      }
    } else {
      System.out.println("Nothing there");
    }
  }
}
