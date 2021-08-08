package StepDefinition.Init.Infrastructure.Driver;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.internal.SystemPropertyUtil;

public class Wait {
    private WebDriver driver;
    private JavascriptExecutor executor;
    private WebDriverWait wait;
    private Action action;
    
    public Wait(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.action = new Action(driver);
    }

    public boolean WaitProgressBarInTheSecond(By ELEMENT, String second){
      int timeout = 180000;
      long currentWaitTime = 0;
      long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
      boolean result = true;
      while(action.GetValue(ELEMENT) == second ){
        currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
        if(currentWaitTime >=timeout )
        {
          result =false;
          System.out.println(ELEMENT.toString()+" Not Found.");
          break;
        }
      }
      return result;
    }

    public boolean WaitComponentByText(By ELEMENT, String expectedText){
        int timeout = 300000;
        long currentWaitTime = 0;
        long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
        boolean result = true;
        while(action.GetText(ELEMENT) == expectedText){
          currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
          if(currentWaitTime >=timeout )
          {
            result =false;
            System.out.println(ELEMENT.toString()+" Not Found.");
            break;
          }
        }
        return result;
    }

      
  public boolean WaitLoading(By ELEMENT){
    int timeout = 60000;
    long currentWaitTime = 0;
    long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
    boolean result = true;
    while(action.isVisible(ELEMENT) == true ){
      currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
      if(currentWaitTime >=timeout )
      {
        result =false;
        System.out.println(ELEMENT.toString()+" Not Found.");
        break;

      }
    }
    return result;
  }

  public boolean WaitComponent(By ELEMENT){
    int timeout = 45000;
    long currentWaitTime = 0;
    long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
    boolean result = true;
    while(action.isVisible(ELEMENT) == false ){
      currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
      if(currentWaitTime >=timeout )
      {
        result =false;
        System.out.println(ELEMENT.toString()+" Not Found.");
        break;
      }
    }
    return result;
  }
}
