package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage {
  private static final String CLOUD_GOOGLE_HOME_PAGE = "http://cloud.google.com/";
  private static final String SEARCH_QUERRY = "Google Cloud Platform Pricing Calculator";
  private WebDriver driver;

  @FindBy(className = "devsite-search-form")
  WebElement searchButton;

  @FindBy(name = "q")
  WebElement searchInput;

  @FindBy(xpath = "//devsite-iframe/child::*")
  WebElement devsiteFrame;

  @FindBy(xpath = "//iframe[@id='myFrame']")
  WebElement calculatorFrame;

  public CloudGoogleHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public CloudGoogleHomePage openPage() {
    driver.get(CLOUD_GOOGLE_HOME_PAGE);
    return this;
  }

  public CloudGoogleHomePage searchForGoogleCloudPlatformPricingCalculator() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(searchButton))
        .click();
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(searchInput))
        .sendKeys(SEARCH_QUERRY);
    searchInput.sendKeys(Keys.ENTER);
    return this;
  }

  public GoogleCloudPricingCalculatorPage swichToTheGoogleCloudPlatformPricingCalculatorPage() {
    new WebDriverWait(driver, 10)
        .until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//div[@class='gsc-thumbnail-inside']/descendant::b[text()='"
                        + SEARCH_QUERRY
                        + "']")))
        .click();
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(devsiteFrame));
    driver.switchTo().frame(devsiteFrame);
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(calculatorFrame));
    driver.switchTo().frame(calculatorFrame);
    return new GoogleCloudPricingCalculatorPage(driver);
  }
}
