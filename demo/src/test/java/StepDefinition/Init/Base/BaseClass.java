package StepDefinition.Init.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import StepDefinition.Init.Infrastructure.Driver.Action;
import StepDefinition.Init.Infrastructure.Driver.Setup;
import StepDefinition.Init.Infrastructure.Driver.Wait;

public class BaseClass {
    protected WebDriver driver;
    protected Action action;
    protected Wait wait;

    public BaseClass() {
        this.driver = Setup.driver;
        this.action = new Action(this.driver);
        this.wait = new Wait(driver);
    }
}
