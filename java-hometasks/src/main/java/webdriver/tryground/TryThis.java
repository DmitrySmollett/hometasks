package webdriver.tryground;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TryThis {
  public static void main(String[] args) {
    WebDriver chromeDriver = new ChromeDriver();

    chromeDriver.get("http://www.nooooooooooooooo.com/");
    WebElement button = WaitForElementLocatedBy(chromeDriver, By.xpath("//*[@id='no-button']"));
    button.click();

    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    chromeDriver.quit();
  }

  private static WebElement WaitForElementLocatedBy(WebDriver driver, By by) {
    return new WebDriverWait(driver, 5)
        .until(ExpectedConditions.presenceOfElementLocated(by));
  }

  //    WebDriver firefoxDriver = new FirefoxDriver();
  //    firefoxDriver.get("http://www.selenium.dev/");
  //    firefoxDriver.quit();
  //
  //    WebDriver operaDriver = new OperaDriver();
  //    operaDriver.get("http://www.selenium.dev/");
  //    operaDriver.quit();

}
