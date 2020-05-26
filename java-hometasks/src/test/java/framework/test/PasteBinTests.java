package framework.test;

import framework.model.pastebin.Paste;
import framework.page.PastebinHomePage;
import framework.service.PasteCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasteBinTests extends CommonConditions {

  @Test(description = "I Can Win Test")
  public void pasteCanBeCreated() {
    Paste paste = PasteCreator.withDataFromProperty();
    boolean pageTitleMatchesTheOriginalOne =
        new PastebinHomePage(driver)
            .openPage()
            .inputGeneralPaste(paste.getPaste())
            .selectExpirationTimeAs10Minutes()
            .inputTitle(paste.getTitleOfThePaste())
            .titleOfCreatedPasteContainsEnteredTitle();
    Assert.assertTrue(
        pageTitleMatchesTheOriginalOne,
        "Title of a new pastebin page doesn't match the original one");
  }

  @Test(description = "Bring It On Test")
  public void generatedPasteMatchesTheChosenOne() {
    Paste paste = PasteCreator.withDataFromProperty();
    boolean pastebinExactMatch =
        new PastebinHomePage(driver)
            .openPage()
            .inputGeneralPaste(paste.getPaste())
            .selectSyntaxStyleAsBash()
            .selectExpirationTimeAs10Minutes()
            .inputTitle(paste.getTitleOfThePaste())
            .sendPaste()
            .newPasteMatchesTheChosenOne();
    Assert.assertTrue(pastebinExactMatch, "New paste doesn'd match the chosen one");
  }
}
