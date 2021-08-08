package StepDefinition.Init.Infrastructure.Driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Setup {
    public static WebDriver driver;

    public String GetCurrentPath(){
      return System.getProperty("user.dir");
    }

    @Before
    public void LaunchTheBrowser(){
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver",
          GetCurrentPath()+"\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1536, 825));
        driver.manage().window().maximize();
    }

    @Given("User navigated to music youtube")
    public void SystemNavigatedByParam(){
        driver.navigate().to("http://music.youtube.com");
    }

    public static String DownloadPath(){
      String downloadPath = System.getProperty("user.home");
      return downloadPath+"\\Downloads\\";
    }
}
