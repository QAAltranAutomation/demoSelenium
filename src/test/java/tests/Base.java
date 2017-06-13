package tests;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
  private static final Logger logger = Logger.getLogger(Base.class.getName());

  protected WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    logger.log(Level.FINE, "BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
    logger.log(Level.FINE, "AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
    logger.log(Level.FINE, "BeforeClass");
  }

  @AfterClass
  public void afterClass() {
    logger.log(Level.FINE, "AfterClass");
  }

  @Parameters({"browser", "platform"})
  @BeforeTest
  public void setUp(@Optional String browser, @Optional String platform) {
    logger.log(Level.FINE, String.format("setUp - browser: %s, platform: %s", browser, platform));

    driver = tests.BrowserType.BrowserType.Execute(browser, platform);
  }

  @AfterTest
  public void tearDown() {
    logger.log(Level.FINE, "tearDown");

    driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
    logger.log(Level.FINE, "BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
    logger.log(Level.FINE, "AfterSuite");
  }

}
