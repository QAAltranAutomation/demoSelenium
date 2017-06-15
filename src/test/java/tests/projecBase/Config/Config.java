package tests.projecBase.Config;

public class Config {
  public static String defaultBrowser = System.getProperty("browser", "chrome");
  public static String defaultBrowserVersion = System.getProperty("version", "59");
  public static String defaultPlatform = System.getProperty("platform", "local");

  public static String baseUrl = System.getProperty("baseUrl", "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");


}
