package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
  protected WebDriver driver;
  protected final Logger logger = LogManager.getRootLogger();

  protected final int WAIT_TIMEOUT_SECONDS = 40;

  protected AbstractPage(WebDriver driver)
  {
    logger.info(driver.toString());
    this.driver = driver;
    logger.info(driver.toString());
  }
}