package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Search {

    private WebDriver driver;

    public Search(){
        
    }

    @Before
    public void LaunchTheBrowser(){
        System.setProperty("webdriver.chrome.driver",
          "D:/Formulatrix/Automation/Flo Automation/flotest/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1536, 825));
        //driver.navigate().to("http://raspberrypi:5005/");
    }
    
    @Given("User navigated to music youtube")
    public void SystemNavigatedByParam(){
        driver.navigate().to("http://music.youtube.com");
    }
}
