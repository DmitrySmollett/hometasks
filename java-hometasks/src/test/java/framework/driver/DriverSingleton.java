package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
  protected final static Logger singletonLogger = LogManager.getRootLogger();

  private static WebDriver driver;

  private DriverSingleton() {}

  public static WebDriver getDriver() {
    singletonLogger.info("Current driver link - " + driver);
    if (driver == null) {
      singletonLogger.info(System.getProperty("browser"));
      switch (System.getProperty("browser")) {
        case "firefox":
          {
            singletonLogger.info("Firefox setup started");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            singletonLogger.info(driver.toString());
            break;
          }
        default:
          {
            singletonLogger.info("Chrome setup started");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            singletonLogger.info(driver.toString());
          }
      }
      driver.manage().window().maximize();
    }
    singletonLogger.info("Pre return check " + driver.toString());
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
