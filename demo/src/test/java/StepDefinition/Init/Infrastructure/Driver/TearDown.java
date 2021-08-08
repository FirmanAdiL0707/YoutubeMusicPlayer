package StepDefinition.Init.Infrastructure.Driver;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class TearDown {

    private WebDriver driver;

    public TearDown() {
        this.driver = Setup.driver;
    }

    // @After
    // public void quitDriver(){
    //     this.driver.quit();
    // }

}
