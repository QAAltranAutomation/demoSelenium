package tests.projecBase.Config;

public class Config {
  public static String defaultBrowser = System.getProperty("browser", "firefox");
  public static String defaultBrowserVersion = System.getProperty("version", "53");
  public static String defaultPlatform = System.getProperty("platform", "local");

  public static String baseUrl = System.getProperty("https://www.gmail.com");


}
