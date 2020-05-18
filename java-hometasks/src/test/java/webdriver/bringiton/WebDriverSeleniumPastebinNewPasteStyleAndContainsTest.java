package webdriver.bringiton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumPastebinNewPasteStyleAndContainsTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void browserSetup() {
    driver = new ChromeDriver();
  }

  @Test(
      description =
          "The title style and text of a new paste created by pastebin matches the chosen one")
  public void noooButtonIsDisplayedInAction() {
    String text =
        "git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force";
    String title = "how to gain dominance among developers";
    boolean pastebinExactMatch =
        new PastebinHomePage(driver)
            .openPage()
            .inputGeneralPaste(text)
            .selectSyntaxStyleAsBash()
            .selectExpirationTimeAs10Minutes()
            .inputTitle(title)
            .sendPaste()
            .newPasteMatchesTheChosenOne();
    Assert.assertTrue(pastebinExactMatch, "New paste doesn'd match the chosen one");
  }

  @AfterMethod(alwaysRun = true)
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }
}
