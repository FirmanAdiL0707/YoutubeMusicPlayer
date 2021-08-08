package StepDefinition;

import static org.junit.Assert.assertEquals;

import PageObject.StreamingMusic.StreamingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Streaming {
    
    private StreamingPage _streaming;
    
    public Streaming(){
        _streaming = new StreamingPage();
    }

    @Then("Validate that {string} playing")
    public void ValidateThatMusicStreaming(String expectedTitle){
        _streaming.SkipAds();
        assertEquals(expectedTitle, _streaming.ValidateMusicTitleOnPlayerBar());
    }

    @Then("Validate that slidebar appears")
    public void ValidateThatSlidebarAppears(){
        assertEquals(1, _streaming.ValidateThatSlideBarAppears());
    }

    @And("User click pause at {string} second after play")
    public void ClickPauseButton(String second){
        _streaming.ClickPauseButton(second);
    }

    @Then("Validate button change become {string}")
    public void ValidateButtonAfterClickPauseButton(String button){
       assertEquals(button, _streaming.ValidateButtonPlayorPause());
    }
}
