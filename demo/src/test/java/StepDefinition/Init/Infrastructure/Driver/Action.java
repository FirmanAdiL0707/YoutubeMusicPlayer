package StepDefinition.Init.Infrastructure.Driver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Action {
  private WebDriver driver;
  private JavascriptExecutor executor;
  private WebDriverWait wait;
  private Actions act;

  public Action(WebDriver driver) {
    this.driver = driver;
    this.executor = (JavascriptExecutor)driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    this.act = new Actions(driver);
  }

  public void SetText(By ELEMENT, String text){
    act.click(driver.findElement(ELEMENT)).sendKeys(text).release().build().perform();
    act.sendKeys(Keys.ENTER).release().build().perform();
  }

  public void TypingText(){
    //act.sendKeys(text).release().build().perform();
    // assuming driver is a healthy WebDriver instance
    //WebElement fileInput = driver.findElement(By.name("uploadfile"));
    act.sendKeys("user.dir"+"\\src\\test\\resources\\DataProtocols\\Uploaded Protocol_service.flo.zip").release().build().perform();
    //fileInput.sendKeys(System.getProperty("user.dir"+"\\src\\test\\resources\\DataProtocols\\Uploaded Protocol_service.flo.zip"));
  }

  public void PressEnter(){
    act.sendKeys(Keys.ENTER).release().build().perform();
  }

  public void EnterText(By textbox, String input) {
    // WebElement element = driver.findElement(textbox);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textbox));
    //driver.findElement(textbox).clear();
    element.sendKeys(Keys.CONTROL, "a");
    element.sendKeys(Keys.BACK_SPACE);
    element.sendKeys(input);
  }

  public void SelectOption(By combobox, String option) {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(combobox));
    Select select = new Select(element);
    select.selectByVisibleText(option);
  }

  public void DragAndDrop(By source, By destination){
    WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(source));
    WebElement sourceDestination = driver.findElement(destination);

    //HTML 5 
    final String java_script =
            "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
            "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
            "ction(format,data){this.items[format]=data;this.types.append(for" +
            "mat);},getData:function(format){return this.items[format];},clea" +
            "rData:function(format){}};var emit=function(event,target){var ev" +
            "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
            "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
            "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
            "'drop',tgt);emit('dragend',src);";
    executor.executeScript(java_script, sourceElement, sourceDestination);
  }
  
  public String GetText(By element) {
    //return driver.findElement(element).getText();
    return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
  }

  public String GetValue(By element) {
    return driver.findElement(element).getAttribute("value");
  }

  public void Click(By ELEMENT) {
    // driver.findElement(ELEMENT).click();
    wait.until(ExpectedConditions.elementToBeClickable(ELEMENT)).click();
    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
  }

  public boolean isEnabled(By ELEMENT) {
    return driver.findElement(ELEMENT).isEnabled();
  }

  public boolean isElementDisabled(By ELEMENT){
     String element = driver.findElement(ELEMENT).getAttribute("class");
     boolean isDisabled = element.contains("disabled");
     return isDisabled;
  }

  public boolean isVisible(By ELEMENT) {
    return driver.findElement(ELEMENT).isDisplayed();
  }

  public int IsElementExists(By ELEMENT){
    List<WebElement> dynamicElement = driver.findElements(ELEMENT);
    return dynamicElement.size();
  }

  public String GetColor(By ELEMENT) {
    return driver.findElement(ELEMENT).getCssValue("color");
  }

  public void ClearText(By ELEMENT) {
    driver.findElement(ELEMENT).clear();
  }

  public int GetHeight(By ELEMENT){
    return driver.findElement(ELEMENT).getSize().getHeight();
  }

  public int GetWidth(By ELEMENT){
    return driver.findElement(ELEMENT).getSize().getWidth();
  }

  public void SwitchContent(By ELEMENT){
    driver.switchTo().frame(driver.findElement(ELEMENT));
  }

  public void SwitchToDefaultContent(){
    driver.switchTo().defaultContent();
  }
}
