package pageObjects.projectBasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Constants;



public class LoginPage extends pageObjects.Base {
  /**
   * gmail Locator's
   */
  
  By signInButton = By.className("gmail-nav__nav-link gmail-nav__nav-link__sign-in");
  By userNameLocator = By.id("identifierId");
  By nextElementButton = By.className("CwaK9");
  By passWordLocator = By.cssSelector(".whsOnd.zHQkBf");
  By buttonLogin = By.cssSelector(".RveJvd.snByac");
  

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public LoginPage(WebDriver driver, String url) {
    super(driver);
    visit(url);
  }
  
  public void pulsarSignIn(){
    if (isDisplayed(signInButton)){
      click(signInButton);
    }
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
      type(pass,passWordLocator);
    }
 }
  public void clickButtonNextLogin(){
    if(isDisplayed(buttonLogin)){
      click(buttonLogin);
    }
  }
  public Boolean isUserLoggedIn() {
    return getCurrentUrl().contains(Constants.INITPAGE);
  }
}