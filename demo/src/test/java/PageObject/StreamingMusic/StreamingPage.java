package PageObject.StreamingMusic;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Init.Base.BaseClass;

public class StreamingPage extends BaseClass {
    
    private By MUSICTITLEONPLAYERBAR = By.cssSelector("#layout > ytmusic-player-bar > div.middle-controls.style-scope.ytmusic-player-bar > div.content-info-wrapper.style-scope.ytmusic-player-bar > yt-formatted-string");
    private By SKIPBUTTON = By.cssSelector("button[class='ytp-ad-skip-button ytp-button']");
    private By SLIDEBAR = By.id("sliderBar");
    private By PLAYPAUSEBUTTON = By.cssSelector("#play-pause-button");
    
    public StreamingPage(){
        PageFactory.initElements(driver, this);
    }

    public String ValidateMusicTitleOnListByNumber(String number){
        By List = By.cssSelector("#contents > ytmusic-player-queue-item:nth-child("+number+") > div.song-info.style-scope.ytmusic-player-queue-item > yt-formatted-string");
        return action.GetText(List);
    }

    public String ValidateMusicTitleOnPlayerBar(){
        return action.GetText(MUSICTITLEONPLAYERBAR);
    }

    public void SkipAds(){
        if(action.IsElementExists(SKIPBUTTON) == 1){
            action.Click(SKIPBUTTON);
        }
    }

    public int ValidateThatSlideBarAppears(){
        return action.IsElementExists(SLIDEBAR);
    }

    public void ClickPauseButton(String second){
        if(wait.WaitProgressBarInTheSecond(SLIDEBAR, second)){
            action.Click(PLAYPAUSEBUTTON);
        }
    }

    public String ValidateButtonPlayorPause(){
        return driver.findElement(PLAYPAUSEBUTTON).getAttribute("title");
    }
    
}
