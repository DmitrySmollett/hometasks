package webdriver.icanwin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumPastebinHomePageTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void browserSetup() {
    driver = new ChromeDriver();
  }

  @Test(description = "pastebin can be created")
  public void noooButtonIsDisplayedInAction() {
    boolean pageTitleMatchesTheOriginalOne =
        new PastebinHomePage(driver)
            .openPage()
            .inputGeneralPaste("Hello from WebDriver")
            .selectExpirationTimeAs10Minutes()
            .inputTitle("helloweb")
            .sendPaste()
            .titleOfCreatedPasteContainsEnteredTitle();
    Assert.assertTrue(
        pageTitleMatchesTheOriginalOne,
        "Title of a new bastebin page doesn't match the original one");
  }

  @AfterMethod(alwaysRun = true)
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }
}
