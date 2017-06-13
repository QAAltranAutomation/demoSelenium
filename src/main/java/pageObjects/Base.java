package pageObjects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {

  private static final Logger logger = Logger.getLogger(Base.class.getName());

  private WebDriver driver;

  public Base(WebDriver driver) {
    this.driver = driver;
  }
  public void visit(String url) {
    if (StringUtils.isNotEmpty(url) && url.contains("http")) {
      driver.get(url);
    }
  }

  public WebElement find(By locator) {
    return this.driver.findElement(locator);
  }

  public WebElement find(By locator, long maxWaitSeconds) {
    waitFor(ExpectedConditions.presenceOfElementLocated(locator), maxWaitSeconds);
    return this.driver.findElement(locator);
  }

  public void click(By locator) {
    find(locator).click();
  }

  public void click(By locator, long maxWaitSeconds) {
    find(locator, maxWaitSeconds).click();
  }

  public void clear(By locator) {
    find(locator).clear();
  }

  public void clear(By locator, long maxWaitSeconds) {
    find(locator, maxWaitSeconds).clear();
  }

  public void getText(By locator) {
    find(locator).getText();
  }
  
  public void compareTo(String inputText, By locator){
    find(locator).getText().compareTo(inputText);
  }
  public Boolean cointains(String inputText, By locator){
    try{
      return this.find(locator).getText().contains(inputText);
    }catch (org.openqa.selenium.NoSuchElementException ex) {
      logger.log(Level.WARNING, String.format("Element \"%s\" not found.", locator), ex);
      return false;
    }
  }
  public Boolean isEqual(String inputText, By locator){
   try{
     return this.find(locator).getText().equals(inputText);
   }catch (org.openqa.selenium.NoSuchElementException ex) {
     logger.log(Level.WARNING, String.format("Element \"%s\" not found.", locator), ex);
     return false;
   }
  }
  
  public void subString(By loccator, Integer x, Integer y ){
    find(loccator).getText().substring(x,y);
  }
  
  public void matchString(By locator, String cadena){
    find(locator).getText().substring(15,  25).matches(cadena);
  }
  
  public void type(String inputText, By locator) {
    find(locator).sendKeys(inputText);
  }

  public void type(String inputText, By locator, long maxWaitSeconds) {
    find(locator, maxWaitSeconds).sendKeys(inputText);
  }
  
  public void switchToFrame(String frameId) {
    driver.switchTo().frame(frameId);
  }
  public void switchToFrameIndex(Integer index) {
      driver.switchTo().frame(index);
  }
  public void switchToActiveElement(){
    driver.switchTo().activeElement();
  }
  
   public void switchToDefaultContent(){
    driver.switchTo().defaultContent();
  }
  
  public void switchToParentFrame() {
    driver.switchTo().parentFrame();
  }
  public Boolean isDisplayed(By locator) {
    try {
      return this.find(locator).isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException ex) {
      logger.log(Level.WARNING, String.format("Element \"%s\" not found.", locator), ex);
      return false;
    }
  }

  public Boolean isDisplayed(By locator, long maxWaitSeconds) {
    try {
      waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxWaitSeconds);
    } catch (org.openqa.selenium.TimeoutException ex) {
      logger.log(Level.WARNING,
          String.format("Element \"%s\" not found after waiting %s secs.", locator, maxWaitSeconds),
          ex);
      return false;
    }
    return this.find(locator).isDisplayed();
  }

  public void refreshCurrentPage() {
    driver.navigate().to(driver.getCurrentUrl());
  }

  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }
  
  public void srollToBottom(){
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0, 1500)");
  }
  public void srollToTop(){
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(1500, 0)");
  }
  public void srollUp(){
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(350, 0)");
  }
  public void scrollDown(){
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0, 350)");
  }

  public boolean isEmpty(By locator){
    try {
      return find(locator).getText().isEmpty();
    } catch (org.openqa.selenium.NoSuchElementException ex) {
      return false;
    }
  }
  /***
   * Waits until a new window opens or the current is redirected to a Url wich contains
   * the @urlFraction
   * 
   * @param urlFraction Url fraction to look for (e.g. /local/webbook/book.php)
   * @param maxWaitSeconds Max time in seconds to wait
   */

  private void waitFor(ExpectedCondition<WebElement> condition, long maxWaitSeconds) {
    maxWaitSeconds = maxWaitSeconds > 0 ? maxWaitSeconds : 5;
    WebDriverWait wait = new WebDriverWait(driver, maxWaitSeconds);
    wait.until(condition);
  }
}
