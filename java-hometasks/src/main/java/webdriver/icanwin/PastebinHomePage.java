package webdriver.icanwin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
  private static final String PASTEBIN_HOME_PAGE = "http://pastebin.com/";
  private String title;
  private WebDriver driver;

  @FindBy(xpath = "//textarea[@name='paste_code']")
  private WebElement generalInputField;

  @FindBy(
      xpath =
          "//*[contains(text(), 'Paste Expiration:')]/parent::*/descendant::span[@class='selection']")
  private WebElement expirationTimeBox;

  @FindBy(xpath = "//li[contains(text(), '10 Minutes')]")
  private WebElement expirationTimeBoxTenMinutesOption;

  @FindBy(xpath = "//input[@name='paste_name']")
  private WebElement titleInputField;

  @FindBy(xpath = "//input[@name='submit']")
  private WebElement submitPasteButton;

  public PastebinHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public PastebinHomePage openPage() {
    driver.get(PASTEBIN_HOME_PAGE);
    return this;
  }

  public PastebinHomePage inputGeneralPaste(String paste) {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(generalInputField))
        .sendKeys(paste);
    return this;
  }

  public PastebinHomePage selectExpirationTimeAs10Minutes() {
    clickElementWhenAvailable(expirationTimeBox);
    clickElementWhenAvailable(expirationTimeBoxTenMinutesOption);
    return this;
  }

  public PastebinHomePage inputTitle(String title) {
    this.title = title;
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(titleInputField))
        .sendKeys(title);
    return this;
  }

  public PastebinHomePage sendPaste() {
    clickElementWhenAvailable(submitPasteButton);
    return this;
  }

  public boolean titleOfCreatedPasteContainsEnteredTitle() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(title));
    return true;
  }

  private void clickElementWhenAvailable(WebElement element) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element)).click();
  }
}
