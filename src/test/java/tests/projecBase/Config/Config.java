package tests.projecBase.Config;

public class Config {
  public static String defaultBrowser = System.getProperty("browser", "firefox");
  public static String defaultPlatform = System.getProperty("platform", "local");

  public static String baseUrl = System.getProperty("baseUrl", "http://www.altran.es/");


}
