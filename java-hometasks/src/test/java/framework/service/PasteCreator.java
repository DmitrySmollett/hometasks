package framework.service;

import framework.model.pastebin.Paste;

public class PasteCreator {
  public static final String TESTDATA_PASTE = "testdata.paste";
  public static final String TESTDATA_PASTE_TITLE = "testdata.paste.title";

  public static Paste withDataFromProperty(){
    return new Paste(TestDataReader.getTestData(TESTDATA_PASTE),
        TestDataReader.getTestData(TESTDATA_PASTE_TITLE));
  }
}
