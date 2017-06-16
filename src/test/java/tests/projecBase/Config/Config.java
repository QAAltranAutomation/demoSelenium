package tests.projecBase.Config;

public class Config {
  public static String defaultBrowser = System.getProperty("browser", "chrome");
  public static String defaultBrowserVersion = System.getProperty("version", "59");
  public static String defaultPlatform = System.getProperty("platform", "local");

  public static String baseUrl = System.getProperty("https://www.google.com/gmail/about/#");


}
