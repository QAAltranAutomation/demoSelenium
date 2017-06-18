package tests.caser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.projectBasePages.PaginaPrincipalCaser;



public class RegistrarUsuario  extends tests.Base {

  private PaginaPrincipalCaser paginaPrincipalCaser; 
  @Parameters({"url", "username", "password"})
  @Test
  public void registroUsuarioCaser(@Optional String url, @Optional String username,
      @Optional String password) throws Exception {
   paginaPrincipalCaser = new PaginaPrincipalCaser(driver);
   paginaPrincipalCaser.entrarZonaUsuario();
   Thread.sleep(1200);
  }
}
