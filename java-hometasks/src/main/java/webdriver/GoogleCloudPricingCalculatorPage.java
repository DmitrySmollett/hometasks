package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage {
  private WebDriver driver;

  @FindBy(
      xpath =
          "//md-pagination-wrapper/descendant::div[@title='Compute Engine' and @class='tab-holder compute']")
  private WebElement computeEngineButton;

  @FindBy(id = "input_58")
  private WebElement numberOfInstancesField;

  @FindBy(id = "select_value_label_51")
  private WebElement chooseOperatingSystemField;

  @FindBy(xpath = "//md-option[@value='free']")
  private WebElement chooseOperatingSystemFreeSoftwareOption;

  public GoogleCloudPricingCalculatorPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public GoogleCloudPricingCalculatorPage clickComputeEngineButton() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(computeEngineButton))
        .click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage inputNumberOfInstances(int numberOfInstances) {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(numberOfInstancesField))
        .sendKeys(Integer.toString(numberOfInstances));
    return this;
  }

  public GoogleCloudPricingCalculatorPage pickFreeOperatingSystem() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(chooseOperatingSystemField));
    forceClick(chooseOperatingSystemField);
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(chooseOperatingSystemFreeSoftwareOption));
    forceClick(chooseOperatingSystemFreeSoftwareOption);
    return this;
  }

  //only for elements that continuously ignore clicks
  private void forceClick (WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
  }
}
