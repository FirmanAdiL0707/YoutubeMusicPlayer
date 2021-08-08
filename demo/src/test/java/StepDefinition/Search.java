package StepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageObject.Search.SearchObject;
import StepDefinition.Init.Infrastructure.Driver.Action;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

    private SearchObject _searchObject;
    
    public Search(){
        _searchObject = new SearchObject();
    }

    @And("User click search button")
    public void ClickSearchButton(){
        _searchObject.ClikSearchButton();
    }
    
    @When("User input {string} on input search")
    public void InputTextOnSearchInput(String input){
        _searchObject.InputTextOnSearch(input);
    }

    @Then("Validate that {string} appears on Top Result")
    public void IsTopResultContentAppears(String expected){
        assertEquals(expected, _searchObject.ValidateMusicOnTopResult());
    }

    @And("User click list music on top result")
    public void ClickListMusicOnTopResult(){
        _searchObject.ClickPlayMusicOnTopResult();
    }
}
