package pageObjects.projectBasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaPrincipalCaser extends pageObjects.Base{
  
  By registerButton = By.id("a_608");
  public PaginaPrincipalCaser(WebDriver driver) {
    super(driver);
  }

  public PaginaPrincipalCaser(WebDriver driver, String url) {
    super(driver);
    visit(url);
  }
  public void entrarZonaUsuario(){
    if(isDisplayed(registerButton)){
      click(registerButton);
    }
  }
}
