package tests.BrowserType;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import tests.projecBase.Config.Config;




public class BrowserType {

  private static final Logger logger = Logger.getLogger(BrowserType.class.getName());

  public static WebDriver Execute(String browser, String platform) {
    logger.log(Level.FINE, String
        .format("Creating web driver for browser \"%s\" on \"%s\" platform", browser, platform));

    browser = StringUtils.isNotEmpty(browser) ? browser : Config.defaultBrowser;

    WebDriver driver = null;

    DesiredCapabilities caps = createBrowserCaps(browser);

    if (StringUtils.isNotEmpty(platform)) {
      caps = setCapabilitiesPlatform(platform, caps);
      driver = new RemoteWebDriver(caps);
    } else {
      driver = createLocalDriver(browser, caps);
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();

    return driver;
  }

  private static WebDriver createLocalDriver(String browserName, DesiredCapabilities caps) {
    WebDriver driver = null;

    if ("chrome".equalsIgnoreCase(browserName)) {
      driver = new ChromeDriver();
    } else if ("firefox".equalsIgnoreCase(browserName)) {
      driver = new FirefoxDriver();
    } else if ("safari".equalsIgnoreCase(browserName)) {
      driver = new SafariDriver();
    }

    return driver;
  }

  private static DesiredCapabilities setCapabilitiesPlatform(String platform,
      DesiredCapabilities caps) {

    if (platform.equals("windows")) {
      caps.setPlatform(Platform.WINDOWS);
    } else if (platform.equals("win10")) {
      caps.setPlatform(Platform.WIN10);
    } else if (platform.equals("win8")) {
      caps.setPlatform(Platform.WIN8);
    } else if (platform.equals("mac")) {
      caps.setPlatform(Platform.MAC);
    }

    return caps;
  }

  private static DesiredCapabilities createBrowserCaps(String browser) {
    DesiredCapabilities caps = null;

    if (browser.equalsIgnoreCase("chrome")) {
      caps = DesiredCapabilities.chrome();
      System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver.exe");
    } else if (browser.equalsIgnoreCase("firefox")) {
      caps = DesiredCapabilities.firefox();
      System.setProperty("webdriver.gecko.driver", "/Users/sonia.cepedano/Documents/Automatizacion/geckodriver.exe");
      caps.setCapability("marionette", true);
    } else if (browser.equalsIgnoreCase("ie")) {
      // System.setProperty("webdriver.ie.driver",
      // "C:/Documents/Automation/IEDriverServer.exe");
      caps = DesiredCapabilities.internetExplorer();
      caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
          true);
      caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
    } else if (browser.equalsIgnoreCase("edge")) {
      caps = DesiredCapabilities.edge();
    } else if (browser.equalsIgnoreCase("safari")) {
      caps = DesiredCapabilities.safari();
    } else {
      caps = new DesiredCapabilities();
    }

    return caps;
  }
}
