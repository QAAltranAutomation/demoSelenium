package pageObjects.projectBasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends pageObjects.Base {
  /**
   * gmail Locator's
   */

  By userNameLocator = By.id("identifierId");
  By nextElementButton = By.className("CwaK9");
  By passWordLocator = By.cssSelector(".whsOnd.zHQkBf");
  

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public LoginPage(WebDriver driver, String url) {
    super(driver);
    visit(url);
  }
  
  public void introducirUserName(String nombre){
     if (isDisplayed(userNameLocator)){
       click(userNameLocator);
       clear(userNameLocator);
       type(nombre,userNameLocator);
     }
  }
  public void pulsarSiguiente(){
    if(isDisplayed(nextElementButton)){
      click(nextElementButton);
    }
  }
  public void introducirPassword(String pass){
    if (isDisplayed(passWordLocator)){
      click(passWordLocator);
      clear(passWordLocator);
      type(pass,passWordLocator);
    }
 }
}