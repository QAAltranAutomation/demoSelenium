package tests.login;

import java.awt.AWTException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.projectBasePages.LoginPage;


public class LoginTest extends tests.Base {
  LoginPage loginPage;

  /**
   * This test check if login is correct
   * 
   * @param username
   * @param password
   * @throws AWTException
   */
  @Parameters({"url", "username", "password"})
  @Test
  public void Login(@Optional String url, @Optional String username,
      @Optional String password) throws InterruptedException {

    loginPage = new LoginPage(driver, url);
    //loginPage.pulsarSignIn();
    Thread.sleep(1200);
    String nombre = "sonia.cepedanoduenas";
    loginPage.introducirUserName(nombre);
    Thread.sleep(1200);
    loginPage.pulsarSiguiente();
    Thread.sleep(1200);
    String pass ="Silvia197";
    loginPage.introducirPassword(pass);
    Thread.sleep(1200);
    loginPage.clickButtonNextLogin();
    Thread.sleep(1200);
    loginPage.isUserLoggedIn();
  }
}
