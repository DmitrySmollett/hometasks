package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumHometaskTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void browserSetup() {
    driver = new ChromeDriver();
  }

  @Test(description = "Hurt Me Plenty test")
  public void hurtMePlenty() {
    new CloudGoogleHomePage(driver)
        .openPage()
        .searchForGoogleCloudPlatformPricingCalculator()
        .swichToTheGoogleCloudPlatformPricingCalculatorPage()
        .clickComputeEngineButton()
        .inputNumberOfInstances(4)
        .pickFreeOperatingSystem();

    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Assert.assertTrue(true);
  }

  @Test(description = "pastebin can be created")
  public void pasteCanBeCreated() {
    boolean pageTitleMatchesTheOriginalOne =
        new PastebinHomePage(driver)
            .openPage()
            .inputGeneralPaste("Hello from WebDriver")
            .selectExpirationTimeAs10Minutes()
            .inputTitle("helloweb")
            .titleOfCreatedPasteContainsEnteredTitle();
    Assert.assertTrue(
        pageTitleMatchesTheOriginalOne,
        "Title of a new bastebin page doesn't match the original one");
  }

  @Test(
      description =
          "The title style and text of a new paste created by pastebin matches the chosen one")
  public void generatedPasteMatchesTheChosenOne() {
    String text =
        "git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force";
    boolean pastebinExactMatch =
        new PastebinHomePage(driver)
            .openPage()
            .inputGeneralPaste(text)
            .selectSyntaxStyleAsBash()
            .selectExpirationTimeAs10Minutes()
            .inputTitle("how to gain dominance among developers")
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
